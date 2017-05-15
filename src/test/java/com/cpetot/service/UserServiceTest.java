package com.cpetot.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cpetot.entities.Movie;
import com.cpetot.entities.User;
import com.cpetot.exceptions.UserNameNotFoundException;
import com.cpetot.repository.MovieRepository;
import com.cpetot.repository.UserRepository;
import com.cpetot.services.MovieService;
import com.cpetot.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private MovieService movieService;

	@InjectMocks
	private UserService userService;

	// Tests de la méthode getUser
	@Test
	public void shouldThrowException_WhenGetUser_WithUsernameNull() {
		// Given
		String username = null;

		try {
			// When
			userService.getUser(username);
			Assertions.fail("We should not return any user");
		}
		catch (IllegalArgumentException e) {
			// Then
			assertThat(e)
					.hasMessage("Username must not be null");
		}

		verifyZeroInteractions(userRepository);
	}

	@Test
	public void shouldThrowException_WhenGetUser_WithUserNotFound() {
		// Given
		String username = "foo";

		try {
			// When
			userService.getUser(username);
			Assertions.fail("We should not return any user");
		}
		catch (UserNameNotFoundException e) {
			// Then
			assertThat(e)
					.hasMessage("User with username foo does not exist");
		}

		verify(userRepository).findByUsername(username);
	}

	@Test
	public void shouldReturnUser_WhenGetUser_WithUserFound() {
		// Given
		String username = "foo";
		User user = mock(User.class);
		when(userRepository.findByUsername(username)).thenReturn(user);

		// When
		User result = userService.getUser(username);

		assertThat(result).isEqualTo(user);
		verify(userRepository).findByUsername(username);
	}

	// Tests de la méthode addToWatchList
	@Test
	public void shouldAddMovieToUserWatchList_WhenaddToWatchList() {
		// Given
		String username = "foo";
		User user = mock(User.class);
		String movieTitle = "The Lord of the Rings";
		Movie movie = mock(Movie.class);

		when(userRepository.findByUsername(username)).thenReturn(user);
		when(movieService.getByTitle(movieTitle)).thenReturn(movie);

		// When
		userService.addToWatchList(username, movieTitle);

		// Then
		verify(userRepository).findByUsername(username);
		verify(movieService).getByTitle(movieTitle);
		verify(userRepository).save(user);

	}

	// Tests de la méthode getWatchList
	@Test
	public void shouldReturnUserWatchList_WhenGetWatchList() {
		// Given
		String username = "foo";
		User user = mock(User.class);
		when(userRepository.findByUsername(username)).thenReturn(user);

		List<Movie> movies = asList(mock(Movie.class), mock(Movie.class));
		when(user.getWatchList()).thenReturn(movies);

		// When
		List<Movie> result = userService.getWatchList(username);

		// Then
		verify(userRepository).findByUsername(username);
		assertThat(result).isEqualTo(movies);
	}
}
