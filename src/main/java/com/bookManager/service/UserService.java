package com.bookManager.service;

import com.bookManager.dao.model.User;
import com.bookManager.dto.UserDto;

/**
 * Interface defining all User related service level interactions.
 * @author Lance Staley
 *
 */
public interface UserService {
	
	/**
	 * Returns the User with the given userName.
	 * @param userName
	 * @return User
	 */
	User getUserByUserName(String userName);

	/**
	 * Creates a new User in the system.
	 * @param user
	 * @return UserDto
	 */
	UserDto registerUser(UserDto user);
}
