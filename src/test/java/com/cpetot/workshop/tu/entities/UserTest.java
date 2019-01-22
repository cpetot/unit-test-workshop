package com.cpetot.workshop.tu.entities;

import static com.cpetot.workshop.tu.MockInitialisations.mockMovie;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.cpetot.workshop.tu.enums.ContentRating;
import com.cpetot.workshop.tu.exceptions.MovieAlreadyInWatchlistException;
import com.cpetot.workshop.tu.exceptions.UserNotAllowedToWatchException;

public class UserTest {

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

		// When & Then
		user.addWatchMovie(movie);
		assertThatThrownBy(() -> user.addWatchMovie(movie))
				.isInstanceOf(MovieAlreadyInWatchlistException.class)
				.hasMessage("Movie The Lord of the Rings is already in user with username cnorris watchlist");
	}

	@Test
	public void shoulThrowException_WhenAddWatchMovie_WithMovieNotAvailableForAge() {
		// Given
		when(movie.isAvailableForAge(age)).thenReturn(false);

		// When & Then
		assertThatThrownBy(() -> user.addWatchMovie(movie))
				.isInstanceOf(UserNotAllowedToWatchException.class)
				.hasMessage("User with age 15, are not allowed to watch movies with rating PG_16");
	}
}