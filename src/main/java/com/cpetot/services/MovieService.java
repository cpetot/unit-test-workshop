package com.cpetot.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cpetot.entities.Movie;
import com.cpetot.enums.ContentRating;
import com.cpetot.exceptions.MovieAlreadyExistException;
import com.cpetot.exceptions.MovieNotFoundException;
import com.cpetot.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie getByTitle(String title) {
		Assert.isTrue(StringUtils.isNotBlank(title), "Title must not be blank");
		Movie movie = this.movieRepository.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException(title);
		}
		return movie;
	}

	public List<Movie> findMoviesAvailableForAge(int minAge) {
		List<Movie> allMovies = movieRepository.findAll();
		List<Movie> availableMovies = new ArrayList<>();

		for (Movie movie : allMovies) {
			if (movie.isAvailableForAge(minAge)) {
				availableMovies.add(movie);
			}
		}
		return availableMovies;
	}

	@Transactional
	public Movie create(String title, ContentRating rating) {
		if (movieRepository.findByTitle(title) != null) {
			throw new MovieAlreadyExistException(title);
		}

		return movieRepository.save(new Movie(title, rating));
	}
}
