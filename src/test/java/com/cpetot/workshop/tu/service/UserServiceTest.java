package com.cpetot.workshop.tu.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cpetot.workshop.tu.repository.MovieRepository;
import com.cpetot.workshop.tu.repository.UserRepository;
import com.cpetot.workshop.tu.services.MovieService;
import com.cpetot.workshop.tu.services.UserService;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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
	public void should_do_something_when_getUser_with_XXX() {

	}

	// Tests de la méthode addToWatchList

	// Tests de la méthode getWatchList
}
