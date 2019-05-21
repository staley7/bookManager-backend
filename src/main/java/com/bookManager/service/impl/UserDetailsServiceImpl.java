package com.bookManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.UserMapper;
import com.bookManager.dao.model.User;
import static java.util.Collections.emptyList;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User applicationUser = userMapper.findUserByUserName(userName);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new org.springframework.security.core.userdetails.User(applicationUser.getUserName(),
				applicationUser.getPassword(), emptyList());
	}

}
