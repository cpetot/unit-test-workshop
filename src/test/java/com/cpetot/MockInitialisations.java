package com.cpetot;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.cpetot.entities.Movie;
import com.cpetot.enums.ContentRating;

public class MockInitialisations {

	private MockInitialisations() {
		// Util class
	}

	public static Movie mockMovie(String title, ContentRating contentRating) {
		Movie movie = mock(Movie.class);
		when(movie.getTitle()).thenReturn(title);
		when(movie.getRating()).thenReturn(contentRating);
		return movie;
	}

	public static Movie mockMovieAvailableForAge(int age, boolean available) {
		Movie movie = mock(Movie.class);
		when(movie.isAvailableForAge(age)).thenReturn(available);
		return movie;
	}
}
