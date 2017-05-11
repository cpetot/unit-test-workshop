package com.cpetot.exceptions;

public class UserNotAllowedToWatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer userAge;

	private String movieRating;

	public UserNotAllowedToWatchException(Integer userAge, String movieRating) {
		super("User with age " + userAge + ", are not allowed to watch movies with rating " + movieRating);
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
