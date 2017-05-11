package com.cpetot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cpetot.entities.Movie;
import com.cpetot.exceptions.MovieNotFoundException;
import com.cpetot.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepo;

	@Override
	public Movie getByTitle(String title) {
		Assert.notNull(title, "Title must not be null");
		Movie movie = this.movieRepo.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException(title);
		}
		return movie;
	}

}
