package com.cpetot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cpetot.entities.Movie;
import com.cpetot.exceptions.MovieNotFoundException;
import com.cpetot.repository.MovieRepository;
import com.cpetot.services.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;

	@InjectMocks
	private MovieService movieService;

	// Tests de la méthode getByTitle
	@Test
	public void shouldThrowException_WhenGetMovie_WithTitleNull() {
		// Given
		String title = null;

		try {
			// When
			movieService.getByTitle(title);
			Assertions.fail("We should not return any movie");
		}
		catch (IllegalArgumentException e) {
			// Then
			assertThat(e)
					.hasMessage("Title must not be null");
		}

		verifyZeroInteractions(movieRepository);
	}

	@Test
	public void shouldThrowException_WhenGetMovie_WithMovieNotFound() {
		// Given
		String title = "foo";

		try {
			// When
			movieService.getByTitle(title);
			Assertions.fail("We should not return any movie");
		}
		catch (MovieNotFoundException e) {
			// Then
			assertThat(e)
					.hasMessage("Movie with title foo not found");
		}

		verify(movieRepository).findByTitle(title);
	}

	@Test
	public void shouldReturnMovie_WhenGetMovie_WithMovieFound() {
		// Given
		String title = "foo";
		Movie movie = mock(Movie.class);
		when(movieRepository.findByTitle(title)).thenReturn(movie);

		// When
		Movie result = movieService.getByTitle(title);

		assertThat(result).isEqualTo(movie);
		verify(movieRepository).findByTitle(title);
	}

	// Tests de la méthode findMoviesAvailableForAge
}
