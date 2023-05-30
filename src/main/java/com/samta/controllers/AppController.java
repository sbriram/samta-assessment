package com.samta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.samta.entities.Question;
import com.samta.model.NextQuestion;
import com.samta.model.NextQuestionWithPrevAns;
import com.samta.services.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService service;

	/*
	 * This rest api will fetch the 5 random question in the form of list
	 */
	@GetMapping("/fetch")
	public ResponseEntity<List<Question>> getFiveRandomQuestion() {

		List<Question> questions = service.fetchFiveRandomQuestions();
		return ResponseEntity.ok(questions);
	}

	/*
	 * This rest api will fetch list of one random question
	 */
	@GetMapping("/play")
	public ResponseEntity<NextQuestion> getRandomQuestion() {

		List<Question> questions = service.fetchRandomQuestion();

		NextQuestion nextQuestion = new NextQuestion();
		nextQuestion.setQuestionId(questions.get(0).getId());
		nextQuestion.setQuestion(questions.get(0).getQuestion());

		return ResponseEntity.ok(nextQuestion);
	}

	/*
	 * This rest api will fetch the answer of the previous question and the next
	 * question for the player.
	 */
	@PostMapping("/next")
	public ResponseEntity<NextQuestionWithPrevAns> getNextQuestionWithPrevAns(@RequestBody NextQuestion request) {

		return ResponseEntity.ok(service.fetchCorrectAns(request));

	}

}
