package com.samta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAnsOfGivenQuestion {

	@JsonProperty("question_id")
	private Long questionId;

	@JsonProperty("answer")
	private String answer;

}
