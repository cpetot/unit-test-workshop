package com.cpetot.exceptions;

public class MovieAlreadyInWatchlistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String username;
	private String movieTitle;

	public MovieAlreadyInWatchlistException(String username, String movieTitle) {
		super("Movie " + movieTitle + " is already in user with username " + username + " watchlist");
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
