package com.cpetot.service;

import static org.junit.rules.ExpectedException.none;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cpetot.repository.MovieRepository;
import com.cpetot.repository.UserRepository;
import com.cpetot.services.MovieService;
import com.cpetot.services.UserService;

public class UserServiceTest {

	@Rule
	public ExpectedException thrown = none();

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

	}

	// Tests de la méthode addToWatchList

	// Tests de la méthode getWatchList
}
