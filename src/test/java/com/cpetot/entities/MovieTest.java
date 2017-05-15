package com.cpetot.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cpetot.enums.ContentRating;

public class MovieTest {

	private Movie movie;

	@Before
	public void setUp() {
		movie = new Movie(ContentRating.PG_16);
	}

	@Test
	public void shouldReturnTrue_WhenIsAvailableForAge_WithAgeGreaterThanRatingMinAge() {
		// When
		boolean result = movie.isAvailableForAge(movie.getRating().minAge() + 1);

		// Then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldReturnTrue_WhenIsAvailableForAge_WithAgeEqualsToRatingMinAge() {
		// When
		boolean result = movie.isAvailableForAge(movie.getRating().minAge());

		// Then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldReturnFalse_WhenIsAvailableForAge_WithAgeLowerThanRatingMinAge() {
		// When
		boolean result = movie.isAvailableForAge(movie.getRating().minAge() - 1);

		// Then
		assertThat(result).isFalse();
	}

	@Test
	public void shouldSetLastWatchToNow_WhenUpdateLastWatch() {

		// When
		movie.updateLastWatch();

		// Then
		assertThat(movie.getLastWatch())
				.isNotNull()
				.as("on doit avoir la date courante") // modulo temps d'exécution du test
				.isCloseTo(new Date(), 500);

	}
}