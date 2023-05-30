package com.samta.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {

	@Id
	private Long id;
	private String answer;
	private String question;
	private Long value;
	private Date airdate;

	@Column(name = "created_at", insertable = false, updatable = false)
	@JsonProperty("created_at")
	private Date createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	@JsonProperty("updated_at")
	private Date updatedAt;

	@Column(name = "category_id")
	@JsonProperty("category_id")
	private Long categoryId;

	@Column(name = "game_id")
	@JsonProperty("game_id")
	private Long gameId;

	@Column(name = "invalid_count")
	@JsonProperty("invalid_count")
	private Long invalidCount;

	@Embedded
	@JsonProperty("category")
	private Category category;

}
