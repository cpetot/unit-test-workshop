package com.cpetot.entities;

import static com.cpetot.MockInitialisations.mockMovie;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cpetot.enums.ContentRating;
import com.cpetot.exceptions.MovieAlreadyInWatchlistException;
import com.cpetot.exceptions.UserNotAllowedToWatchException;

public class UserTest {

	@Rule
	public ExpectedException thrown = none();

	private final int age = 15;
	private User user;
	private Movie movie;

	@Before
	public void setUp() {
		movie = mockMovie("The Lord of the Rings", ContentRating.PG_16);
		user = new User("cnorris", age);
	}

	@Test
	public void shouldAddMovieAndUpdateLastWatch_WhenAddWatchMovie_WithMovieNotWatchedAndAvailable() {
		// Given
		when(movie.isAvailableForAge(age)).thenReturn(true);

		// When
		user.addWatchMovie(movie);

		// Then
		assertThat(user.getWatchList())
				.hasSize(1)
				.containsOnly(movie);

		verify(movie).updateLastWatch();
	}

	@Test
	public void shoulThrowException_WhenAddWatchMovie_WithMovieAlreadyWatched() {
		// Given
		when(movie.isAvailableForAge(age)).thenReturn(true);

		// Then
		thrown.expect(MovieAlreadyInWatchlistException.class);
		thrown.expectMessage("Movie The Lord of the Rings is already in user with username cnorris watchlist");

		// When
		user.addWatchMovie(movie);
		user.addWatchMovie(movie);
	}

	@Test
	public void shoulThrowException_WhenAddWatchMovie_WithMovieNotAvailableForAge() {
		// Given
		when(movie.isAvailableForAge(age)).thenReturn(false);

		// Then
		thrown.expect(UserNotAllowedToWatchException.class);
		thrown.expectMessage("User with age 15, are not allowed to watch movies with rating PG_16");

		// When
		user.addWatchMovie(movie);
		user.addWatchMovie(movie);
	}
}