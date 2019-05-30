package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bookManager.dao.model.User;
import com.bookManager.dto.UserDto;

/**
 * Converts a UserDto to an User
 * 
 * @author Lance Staley
 *
 */
public class UserDtoToUserConverter implements Converter<UserDto, User> {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();
	
	
	@Override
	public User convert(UserDto dto) {
		User user = new User();
		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		user.setCreateDate(dto.getCreateDate());
		user.setCreatedBy(dto.getCreatedBy());
		user.setUpdateDate(dto.getUpdatedDate());
		user.setUpdatedBy(dto.getUpdatedBy());
		return user;
	}

}
