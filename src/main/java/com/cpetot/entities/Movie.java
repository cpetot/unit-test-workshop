package com.cpetot.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cpetot.enums.ContentRating;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Access(AccessType.FIELD)
public class Movie {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String title;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ContentRating rating;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Movie() {

	}

	public ContentRating getRating() {
		return rating;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}
}
