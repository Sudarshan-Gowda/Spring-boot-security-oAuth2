/**
 * 
 */
package com.star.sud.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author Sudarshan
 *
 */
@JsonFilter("DynamicFilterUser")
public class UserDto {

	@NotEmpty(message = "User Name should not be null")
	private String username;

	@NotEmpty(message = "Password should not be null or empty")
	private String password;

	@NotEmpty(message = "Email should not be null or empty")
	private String email;

	@NotNull(message = "Age should not be null")
	private Integer age;

	/**
	 * @param username
	 * @param password
	 * @param email
	 * @param age
	 */
	public UserDto(String username, String password, String email, Integer age) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
