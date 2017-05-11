package com.cpetot.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cpetot.repository.MovieRepository;
import com.cpetot.services.MovieService;
import com.cpetot.services.MovieServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MovieServiceIntegrationTest {

	private MovieService movieService;

	@Autowired
	private MovieRepository repo;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		this.movieService = new MovieServiceImpl(repo);
	}

	@Test
	public void getMovieByTitleShouldReturnMovieAndRating() {
		// TODO Implementar
		// Copiar de MovieServiceTest
		Assert.fail();
	}

	@Test
	public void getNotExistingMovieShouldThrowException() {
		// TODO Implementar
		// Copiar de MovieServiceTest
		Assert.fail();
	}

}
