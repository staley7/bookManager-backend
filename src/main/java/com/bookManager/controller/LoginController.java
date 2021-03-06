package com.bookManager.controller;

import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookManager.dao.model.User;
import com.bookManager.dto.UserDto;
import com.bookManager.service.UserService;

@RestController()
@RequestMapping("/api")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@PostMapping("/logins")
	public boolean login(@RequestBody User user) {
		return user.getUserName().equals("user") && user.getPassword().equals("password");
	}

	@CrossOrigin
	@GetMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}
	
	@CrossOrigin
	@PostMapping("/users/register")
	public UserDto registerUser(@RequestBody UserDto user) {
		this.userService.registerUser(user);
		return user;
	}
	
}
