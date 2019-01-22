/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cpetot.workshop.tu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cpetot.workshop.tu.entities.Movie;
import com.cpetot.workshop.tu.exceptions.MovieNotFoundException;
import com.cpetot.workshop.tu.exceptions.UserNameNotFoundException;
import com.cpetot.workshop.tu.exceptions.UserNotAllowedToWatchException;
import com.cpetot.workshop.tu.services.UserService;

@RestController
public class UserWatchListController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/{username}/watchlist")
	public List<Movie> userWatchList(@PathVariable String username) {
		return this.userService.getWatchList(username);
	}

	@PostMapping("/users/{username}/watchlist")
	public ResponseEntity<RestResponse> addToWatchList(@PathVariable String username, @RequestBody String movieTitle) {
		userService.addToWatchList(username, movieTitle);
		return new ResponseEntity<>(new RestResponse(true, "Movie added succesfully"), HttpStatus.ACCEPTED);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestResponse handleMovieNotFound(MovieNotFoundException ex) {
		return new RestResponse(false, ex.getMessage());
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestResponse handleUserNotFound(UserNameNotFoundException ex) {
		return new RestResponse(false, ex.getMessage());
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public RestResponse handleUserNotAllowedToWatch(UserNotAllowedToWatchException ex) {
		return new RestResponse(false, ex.getMessage());
	}

}
