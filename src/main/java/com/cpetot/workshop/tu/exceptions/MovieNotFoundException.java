package com.cpetot.workshop.tu.exceptions;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String title;

	public MovieNotFoundException(String title) {
		super(String.format("Movie with title %s not found", title));
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

}
