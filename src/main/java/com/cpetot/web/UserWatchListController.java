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

package com.cpetot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cpetot.entities.Movie;
import com.cpetot.entities.User;
import com.cpetot.exceptions.MovieNotFoundException;
import com.cpetot.exceptions.UserNameNotFoundException;
import com.cpetot.exceptions.UserNotAllowedToWatchException;
import com.cpetot.services.UserService;

/**
 * Controller para retornar información del watchlist de un {@link User}.
 *
 */
@RestController
public class UserWatchListController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{username}/watchlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> userWatchList(@PathVariable String username) {
		return this.userService.getWatchList(username);
	}

	@RequestMapping(value = "/users/{username}/watchlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
	public  RestResponse handleUserNotAllowedToWatch(UserNotAllowedToWatchException ex) {
		return new RestResponse(false, ex.getMessage());
	}

}
