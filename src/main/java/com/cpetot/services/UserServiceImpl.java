package com.cpetot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cpetot.entities.Movie;
import com.cpetot.entities.User;
import com.cpetot.exceptions.UserNameNotFoundException;
import com.cpetot.exceptions.UserNotAllowedToWatchException;
import com.cpetot.repository.MovieRepository;
import com.cpetot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieService movieService;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void addToWatchList(String username, String movieTitle) {
		User user = this.getUser(username);
		Movie movie = movieService.getByTitle(movieTitle);

		if (user.getAge() < movie.getRating().minAge()) {
			throw new UserNotAllowedToWatchException(user.getAge(), movie.getRating().name());
		}

		movie.setUser(user);
		userRepository.save(user);
	}

	@Override
	public List<Movie> getWatchList(String username) {
		User user = this.getUser(username);
		return user.getWatchList();
	}

	@Override
	public User getUser(String username) {
		Assert.notNull(username, "Username must not be null");
		User user = this.userRepository.findByUsername(username);
		if (user == null) {
			throw new UserNameNotFoundException(username);
		}
		return user;
	}

	private boolean movieInWatchlist(List<Movie> watchList, Movie movie) {
		for (Movie currentMovie : watchList) {
			if (currentMovie.getTitle().equalsIgnoreCase(movie.getTitle())) {
				return true;
			}
		}
		return false;
	}

}
