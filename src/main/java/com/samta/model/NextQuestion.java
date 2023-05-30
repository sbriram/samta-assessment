package com.samta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NextQuestion {

	@JsonProperty("question_id")
	private Long questionId;

	@JsonProperty("question")
	private String question;

}
