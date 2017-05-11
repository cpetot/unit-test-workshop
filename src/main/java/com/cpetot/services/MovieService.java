package com.cpetot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cpetot.entities.Movie;
import com.cpetot.exceptions.MovieNotFoundException;
import com.cpetot.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie getByTitle(String title) {
		Assert.notNull(title, "Title must not be null");
		Movie movie = this.movieRepository.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException(title);
		}
		return movie;
	}

	public List<Movie> findMoviesAvailableForAge(int minAge) {
		// A implémenter correctement
		return movieRepository.findAll();
	}
}
