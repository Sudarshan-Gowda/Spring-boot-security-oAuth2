/**
 * 
 */
package com.star.sud.security.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.star.sud.exception.UserNotFoundException;
import com.star.sud.user.dao.UserDao;
import com.star.sud.user.dto.UserDto;
import com.star.sud.user.model.TUser;

/**
 * @author Sudarshan
 *
 */
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		TUser user = userDao.findByUsername(userId);
		if (null == user)
			throw new UsernameNotFoundException("Invalid username or password");

		return new User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private Collection<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public MappingJacksonValue users() {
		List<UserDto> list = new ArrayList<>();
		userDao.findAll().forEach(user -> {
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(user, dto);
			list.add(dto);
		});

		return filterOurUsersDetails(list);
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public ResponseEntity<Object> create(UserDto user) {
		TUser tuser = new TUser();
		BeanUtils.copyProperties(user, tuser);
		tuser.setPassword(encoder.encode(user.getPassword()));
		TUser save = userDao.save(tuser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public MappingJacksonValue usersById(Long id) throws UserNotFoundException {
		TUser findById = userDao.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User record not found for the Id: " + id));

		UserDto dto = new UserDto();
		BeanUtils.copyProperties(findById, dto);

		return filterOurUsersDetails(dto);
	}

	private MappingJacksonValue filterOurUsersDetails(Object obj) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "email", "age");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilterUser", filter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(obj);
		jacksonValue.setFilters(filterProvider);
		return jacksonValue;
	}

}
