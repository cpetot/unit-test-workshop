package com.cpetot.workshop.tu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cpetot.workshop.tu.entities.User;
import com.cpetot.workshop.tu.exceptions.UserNameNotFoundException;
import com.cpetot.workshop.tu.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestResponse handleUserNotFound(UserNameNotFoundException ex) {
		return new RestResponse(false, ex.getMessage());
	}

}
