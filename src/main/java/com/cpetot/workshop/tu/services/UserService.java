package com.cpetot.workshop.tu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cpetot.workshop.tu.entities.Movie;
import com.cpetot.workshop.tu.entities.User;
import com.cpetot.workshop.tu.exceptions.UserNameNotFoundException;
import com.cpetot.workshop.tu.repository.MovieRepository;
import com.cpetot.workshop.tu.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieService movieService;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User getUser(String username) {
		Assert.notNull(username, "Username must not be null");
		User user = this.userRepository.findByUsername(username);
		if (user == null) {
			throw new UserNameNotFoundException(username);
		}
		return user;
	}

	@Transactional
	public void addToWatchList(String username, String movieTitle) {
		User user = this.getUser(username);
		Movie movie = movieService.getByTitle(movieTitle);

		user.addWatchMovie(movie);
		userRepository.save(user);
	}

	public List<Movie> getWatchList(String username) {
		User user = this.getUser(username);
		return user.getWatchList();
	}

}
