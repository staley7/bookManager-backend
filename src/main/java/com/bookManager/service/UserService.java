package com.bookManager.service;

import com.bookManager.dao.model.User;

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
}
