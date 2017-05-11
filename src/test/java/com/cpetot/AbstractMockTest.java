package com.cpetot;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.cpetot.entities.Movie;
import com.cpetot.entities.User;
import com.cpetot.enums.ContentRating;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractMockTest {

	private static final ObjectMapper mapper = new ObjectMapper();

	protected List<User> testUsers() {
		return Arrays.asList(testUser());
	}

	protected User testUser() {
		User user = mock(User.class);
		when(user.getUsername()).thenReturn("clark");
		when(user.getAge()).thenReturn(33);
		when(user.getWatchList()).thenReturn(Arrays.asList(testMovie()));
		return user;
	}

	private Movie testMovie() {
		Movie movie = mock(Movie.class);
		when(movie.getTitle()).thenReturn("Man of Steel");
		when(movie.getRating()).thenReturn(ContentRating.TOUT_PUBLIC);
		return movie;
	}

	protected String usersAsJson() throws JsonProcessingException {
		return mapToJson(testUsers());
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}

	protected Object mapToObject(String contentAsString, Class<?> clazz) throws IOException {
		return mapper.readValue(contentAsString, clazz);
	}

}