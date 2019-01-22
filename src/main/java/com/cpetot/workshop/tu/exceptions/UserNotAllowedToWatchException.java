package com.cpetot.workshop.tu.exceptions;

import com.cpetot.workshop.tu.enums.ContentRating;

public class UserNotAllowedToWatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer userAge;

	private String movieRating;

	public UserNotAllowedToWatchException(Integer userAge, ContentRating movieRating) {
		super(String.format("User with age %s, are not allowed to watch movies with rating %s", userAge, movieRating));
		this.userAge = userAge;
		this.movieRating = movieRating.name();
	}

	public Integer getUserAge() {
		return userAge;
	}

	public String getMovieRating() {
		return movieRating;
	}

}
