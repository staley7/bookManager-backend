package com.bookManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.UserMapper;
import com.bookManager.dao.model.User;
import com.bookManager.dto.UserDto;
import com.bookManager.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("bookManagerConverter")
	private ConversionService converter;

	

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByUserName(String userName) {
		return userMapper.findUserByUserName(userName);
	}

	@Override
	public UserDto registerUser(UserDto dto) {
		User user = converter.convert(dto, User.class);
		userMapper.insertUser(user);
		return dto;
	}

}
