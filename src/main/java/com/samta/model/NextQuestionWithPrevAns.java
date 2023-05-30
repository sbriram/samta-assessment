package com.samta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NextQuestionWithPrevAns {

	@JsonProperty("correct_answer")
	private String correctAnsOfPrevQuestion;

	@JsonProperty("next_question")
	private NextQuestion nextQuestion;

}
