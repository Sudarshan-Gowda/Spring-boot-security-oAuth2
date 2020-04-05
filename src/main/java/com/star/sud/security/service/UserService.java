/**
 * 
 */
package com.star.sud.security.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.star.sud.exception.UserNotFoundException;
import com.star.sud.user.dto.UserDto;

/**
 * @author Sudarshan
 *
 */
public interface UserService {

	/**
	 * @param id
	 */
	void delete(long id);

	/**
	 * @return
	 */
	MappingJacksonValue users();

	/**
	 * @param user
	 * @return
	 */
	ResponseEntity<Object> create(UserDto user);

	/**
	 * @param id
	 * @return
	 * @throws UserNotFoundException
	 */
	MappingJacksonValue usersById(Long id) throws UserNotFoundException;

}
