package com.cpetot;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import com.cpetot.entities.Movie;
import com.cpetot.entities.User;
import com.cpetot.enums.ContentRating;

public abstract class AbstractMockTest {

	protected User mockUser() {
		return mockUser("acucumel", 28, mockMovie());
	}

	protected User mockUser(String username, Integer age, Movie... movies) {
		User user = mock(User.class);
		when(user.getUsername()).thenReturn(username);
		when(user.getAge()).thenReturn(age);
		if (ArrayUtils.isNotEmpty(movies)) {
			when(user.getWatchList()).thenReturn(Arrays.asList(movies));
		}
		return user;
	}

	private Movie mockMovie() {
		return mockMovie("Man of Steel", ContentRating.TOUT_PUBLIC);
	}

	private Movie mockMovie(String title, ContentRating rating) {
		Movie movie = mock(Movie.class);
		when(movie.getTitle()).thenReturn(title);
		when(movie.getRating()).thenReturn(rating);
		return movie;
	}

}