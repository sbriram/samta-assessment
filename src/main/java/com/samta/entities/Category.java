package com.samta.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Embeddable
public class Category {

	@Id
	private Long id;
	private String title;

	@Column(name = "created_at", insertable = false, updatable = false)
	@JsonProperty("created_at")
	private Date createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	@JsonProperty("updated_at")
	private Date updatedAt;

	@Column(name = "clues_count")
	@JsonProperty("clues_count")
	private Long cluesCount;

}
