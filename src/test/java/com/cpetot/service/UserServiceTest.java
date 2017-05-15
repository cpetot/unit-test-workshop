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

	// Tests de la méthode getWatchList
}
