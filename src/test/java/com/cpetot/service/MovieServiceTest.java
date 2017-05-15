package com.cpetot.service;

import static com.cpetot.MockInitialisations.mockMovieAvailableForAge;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

		// When & Then
		assertThatThrownBy(() -> movieService.getByTitle(title))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Title must not be blank");

		verifyZeroInteractions(movieRepository);
	}

	@Test
	public void shouldThrowException_WhenGetMovie_WithTitleBlank() {
		// Given
		String title = "  ";

		// When & Then
		assertThatThrownBy(() -> movieService.getByTitle(title))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Title must not be blank");

		verifyZeroInteractions(movieRepository);
	}

	@Test
	public void shouldThrowException_WhenGetMovie_WithMovieNotFound() {
		// Given
		String title = "foo";

		// When & Then
		assertThatThrownBy(() -> movieService.getByTitle(title))
				.isInstanceOf(MovieNotFoundException.class)
				.hasMessage("Movie with title foo not found");

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
	@Test
	public void shouldReturnOnlyAvailableMovies_WhenFindMoviesAvailableForAge() {
		// Given
		int age = 42;
		Movie movieAvailable1 = mockMovieAvailableForAge(age, true);
		Movie movieAvailable2 = mockMovieAvailableForAge(age, true);
		Movie movieNotAvailable1 = mockMovieAvailableForAge(age, false);
		Movie movieNotAvailable2 = mockMovieAvailableForAge(age, false);
		List<Movie> allMovies = asList(movieAvailable1, movieNotAvailable1, movieAvailable2, movieNotAvailable2);

		when(movieRepository.findAll()).thenReturn(allMovies);

		// When
		List<Movie> result = movieService.findMoviesAvailableForAge(age);

		// Then
		assertThat(result)
				.containsOnly(movieAvailable1, movieAvailable2);

		allMovies.forEach(movie -> verify(movie).isAvailableForAge(age));
	}
}
