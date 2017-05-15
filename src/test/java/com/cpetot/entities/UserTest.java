package com.cpetot.entities;

import static com.cpetot.MockInitialisations.mockMovie;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cpetot.exceptions.MovieAlreadyInWatchlistException;

public class UserTest {

	@Rule
	public ExpectedException thrown = none();

	private final int age = 16;
	private User user;

	@Before
	public void setUp() {
		user = new User("cnorris", 16);
	}

	@Test
	public void shouldAddMovieAndUpdateLastWatch_WhenAddWatchMovie_WithMovieNotWatched() {
		// Given
		Movie movie = mock(Movie.class);

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
		Movie movie = mockMovie("The Lord of the Rings");

		// Then
		thrown.expect(MovieAlreadyInWatchlistException.class);
		thrown.expectMessage("Movie The Lord of the Rings is already in user with username cnorris watchlist");

		// When
		user.addWatchMovie(movie);
		user.addWatchMovie(movie);
	}
}