package com.cpetot.workshop.tu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpetot.workshop.tu.entities.Movie;
import com.cpetot.workshop.tu.repository.MovieRepository;
import com.cpetot.workshop.tu.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@GetMapping("/minAge/{minAge}")
	public List<Movie> findMoviesAvailableForAge(@PathVariable("minAge") int minAge) {
		return movieService.findMoviesAvailableForAge(minAge);
	}

}
