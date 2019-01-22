package com.cpetot.workshop.tu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cpetot.workshop.tu.repository.MovieRepository;
import com.cpetot.workshop.tu.repository.UserRepository;
import com.cpetot.workshop.tu.services.MovieService;
import com.cpetot.workshop.tu.services.UserService;

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
	public void should_do_something() {

	}

	// Tests de la méthode addToWatchList

	// Tests de la méthode getWatchList
}
