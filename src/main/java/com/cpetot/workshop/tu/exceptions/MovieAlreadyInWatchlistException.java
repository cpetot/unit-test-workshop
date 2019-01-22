package com.cpetot.workshop.tu.exceptions;

public class MovieAlreadyInWatchlistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String username;
	private String movieTitle;

	public MovieAlreadyInWatchlistException(String username, String movieTitle) {
		super(String.format("Movie %s is already in user with username %s watchlist", movieTitle, username));
		this.username = username;
		this.movieTitle = movieTitle;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public String getUsername() {
		return username;
	}
}
