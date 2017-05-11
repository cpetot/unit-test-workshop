package com.cpetot.services;

import java.util.List;

import com.cpetot.entities.User;
import com.cpetot.entities.Movie;

public interface UserService {

	List<User> findAll();

	void addToWatchList(String username, String movieTitle);

	List<Movie> getWatchList(String username);

	User getUser(String username);
}
