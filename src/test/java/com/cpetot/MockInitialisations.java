package com.cpetot;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.cpetot.entities.Movie;

public class MockInitialisations {

	private MockInitialisations() {
		// Util class
	}

	public static Movie mockMovie(String title) {
		Movie movie = mock(Movie.class);
		when(movie.getTitle()).thenReturn(title);
		return movie;
	}
}
