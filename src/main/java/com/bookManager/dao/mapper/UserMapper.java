package com.bookManager.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bookManager.dao.model.User;

/**
 * Mapper interface for CRUD operations for the User table.
 * @author Lance Staley
 *
 */
@Mapper
public interface UserMapper {

	public User findUserByUserName(String userName);
	
	public void insertUser(User user);
}
