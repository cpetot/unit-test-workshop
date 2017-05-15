package com.cpetot.workshop.tu.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cpetot.workshop.tu.entities.Movie;
import com.cpetot.workshop.tu.exceptions.MovieNotFoundException;
import com.cpetot.workshop.tu.repository.MovieRepository;

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
		return movieRepository.findAll().stream()
				.filter(movie -> movie.isAvailableForAge(minAge))
				.collect(Collectors.toList());
	}
}
