package com.cpetot.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

public class MovieServiceTest {



	@Rule
	public ExpectedException thrown = ExpectedException.none();


	@Before
	public void setup() {
		// Crea las implementaciones de interfaces anotadas con @Mock
		MockitoAnnotations.initMocks(this);
	}

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
