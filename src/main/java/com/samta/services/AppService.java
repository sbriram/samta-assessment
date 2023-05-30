package com.samta.services;

import java.util.List;

import com.samta.entities.Question;
import com.samta.model.NextQuestion;
import com.samta.model.NextQuestionWithPrevAns;

public interface AppService {

	List<Question> fetchFiveRandomQuestions();

	void saveQuestions(List<Question> questions);

	List<Question> fetchRandomQuestion();

	NextQuestionWithPrevAns fetchCorrectAns(NextQuestion request);

}
