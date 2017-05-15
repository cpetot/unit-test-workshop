package com.cpetot.exceptions;

public class MovieAlreadyExistException extends RuntimeException {

	public MovieAlreadyExistException(String title) {
		super(String.format("Création impossible, le film %s existe déjà", title));
	}
}
