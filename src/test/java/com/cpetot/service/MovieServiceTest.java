package com.cpetot.service;

import static com.cpetot.MockInitialisations.mockMovieAvailableForAge;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cpetot.entities.Movie;
import com.cpetot.enums.ContentRating;
import com.cpetot.exceptions.MovieAlreadyExistException;
import com.cpetot.exceptions.MovieNotFoundException;
import com.cpetot.repository.MovieRepository;
import com.cpetot.services.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;

	@InjectMocks
	private MovieService movieService;

	@Captor
	private ArgumentCaptor<Movie> movieCaptor;

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
					.hasMessage("Title must not be blank");
		}

		verifyZeroInteractions(movieRepository);
	}

	@Test
	public void shouldThrowException_WhenGetMovie_WithTitleBlank() {
		// Given
		String title = "  ";

		try {
			// When
			movieService.getByTitle(title);
			Assertions.fail("We should not return any movie");
		}
		catch (IllegalArgumentException e) {
			// Then
			assertThat(e)
					.hasMessage("Title must not be blank");
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

		for (Movie movie : allMovies) {
			verify(movie).isAvailableForAge(age);
		}
	}

	@Test
	public void shouldCreateTheMovie_WhenCreate_WithNoMovieExistingWithSameTitle() {
		// Given
		String title = "foo";
		ContentRating rating = ContentRating.TOUT_PUBLIC;
		when(movieRepository.save(any(Movie.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());

		// When
		Movie result = movieService.create(title, rating);

		// Then
		verify(movieRepository).findByTitle(title);
		verify(movieRepository).save(movieCaptor.capture());

		Movie savedMovie = movieCaptor.getValue();
		assertThat(savedMovie)
				.isNotNull()
				.isEqualTo(result)
				.extracting("title", "rating")
				.containsExactly(title, rating);
	}

	@Test
	public void shouldThrowException_WhenCreate_WithMovieExistingWithSameTitle() {
		// Given
		String title = "foo";
		ContentRating rating = ContentRating.TOUT_PUBLIC;

		Movie existingMovie = mock(Movie.class);
		when(movieRepository.findByTitle(title)).thenReturn(existingMovie);

		try {
			// When
			Movie result = movieService.create(title, rating);
			fail("Création impossible, le film foo existe déjà");
		}
		catch (MovieAlreadyExistException e) {
			// Then
			assertThat(e).hasMessage("fds");

			verify(movieRepository).findByTitle(title);
			verifyNoMoreInteractions(movieRepository);
		}

	}
}
