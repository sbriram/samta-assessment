package com.samta.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.samta.entities.Question;
import com.samta.exceptions.ResourceNotFoundException;
import com.samta.model.NextQuestion;
import com.samta.model.NextQuestionWithPrevAns;
import com.samta.repo.AppRepository;
import com.samta.services.AppService;
import com.samta.utils.Constants;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private WebClient webClient;

	@Autowired
	private AppRepository appRepository;

	/*
	 * With the help of this line we can return Question list in the WebClient.
	 */
	ParameterizedTypeReference<List<Question>> questionResponse = new ParameterizedTypeReference<List<Question>>() {
	};

	/*
	 * This method fetches five random question's list. In this method I have used
	 * WebClient to communicate with the outer rest url.
	 */
	@Override
	public List<Question> fetchFiveRandomQuestions() {
		List<Question> questions = webClient.get().uri(Constants.URL_RANDOM_FIVE)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve()
				.bodyToMono(questionResponse).block();

		saveQuestions(questions);
		return questions;

	}

	/*
	 * This method saves the questions whatever we will provide.
	 */
	@Override
	public void saveQuestions(List<Question> questions) {

		questions.stream().map(question -> appRepository.save(question)).collect(Collectors.toList());
	}

	/*
	 * This method fetches list of only one random question. In this method also I
	 * have used WebClient.
	 */
	@Override
	public List<Question> fetchRandomQuestion() {
		List<Question> questions = webClient.get().uri(Constants.URL_RANDOM)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve()
				.bodyToMono(questionResponse).block();

		saveQuestions(questions);
		return questions;
	}

	/*
	 * This method fetches the correct answer of the previous question and also
	 * fetches the next question for the user.
	 */
	@Override
	public NextQuestionWithPrevAns fetchCorrectAns(NextQuestion request) {

		/*
		 * To set the correct answer I am fetching the detail of the previous question
		 * from the database
		 */
		Question question = appRepository.findById(request.getQuestionId()).orElseThrow(
				() -> new ResourceNotFoundException("There is no any question detail with this question id"));

		/*
		 * Generating the object of NextQuestionWithPrevAns to set the answer and to set
		 * the next question detail
		 */
		NextQuestionWithPrevAns response = new NextQuestionWithPrevAns();

		// setting the answer of previous question
		response.setCorrectAnsOfPrevQuestion(question.getAnswer());

		// Generating the object of NextQuestion to set the question detail
		NextQuestion nextQuestion = new NextQuestion();

		List<Question> questions = fetchRandomQuestion();
		/*
		 * Saving the question detail into data base. It was not asked but if we will
		 * save the question in the data base then user will not get any exception when
		 * he hits the '/next' url.
		 * 
		 */
		saveQuestions(questions);

		// Setting the question id and question to the nextQuestion object.
		nextQuestion.setQuestionId(questions.get(0).getId());
		nextQuestion.setQuestion(questions.get(0).getQuestion());

		// Setting the next question object to the response object.
		response.setNextQuestion(nextQuestion);

		return response;
	}

}
