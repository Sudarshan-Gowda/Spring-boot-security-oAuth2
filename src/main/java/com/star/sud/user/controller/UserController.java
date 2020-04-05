/**
 * 
 */
package com.star.sud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.star.sud.exception.UserNotFoundException;
import com.star.sud.security.service.UserService;
import com.star.sud.user.dto.UserDto;

/**
 * @author Sudarshan
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/users")
	public MappingJacksonValue users() {
		return userService.users();
	}

	@GetMapping(value = "/users/{id}")
	public MappingJacksonValue users(@PathVariable Long id) throws UserNotFoundException {
		return userService.usersById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUsers(@RequestBody UserDto user) {
		return userService.create(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable("id") Long id) {
		userService.delete(id);
	}

}
