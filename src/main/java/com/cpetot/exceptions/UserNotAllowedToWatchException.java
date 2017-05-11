package com.cpetot.exceptions;

public class UserNotAllowedToWatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer userAge;

	private String movieRating;

	public UserNotAllowedToWatchException(Integer userAge, String movieRating) {
		super(String.format("User with age %s, are not allowed to watch movies with rating %s", userAge, movieRating));
		this.userAge = userAge;
		this.movieRating = movieRating;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public String getMovieRating() {
		return movieRating;
	}

}
