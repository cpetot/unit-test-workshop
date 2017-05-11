package com.cpetot.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void getMovieByTitleShouldReturnMovieAndRating() {
		// TODO Implementar
		Assert.fail();
	}

	@Test
	public void getNotExistingMovieShouldThrowException() {
		// TODO Implementar
		Assert.fail();
	}
}
