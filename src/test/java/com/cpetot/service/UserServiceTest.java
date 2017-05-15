package com.cpetot.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

	// Tests de la méthode addToWatchList

	// Tests de la méthode getWatchList
}
