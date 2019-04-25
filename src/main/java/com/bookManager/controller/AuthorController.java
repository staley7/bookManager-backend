package com.bookManager.controller;

import org.slf4j.LoggerFactory;

import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import com.bookManager.dao.model.Author;
import com.bookManager.service.AuthorService;

@RestController()
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);
	
	//TODO
	@CrossOrigin
	@RequestMapping(value =  "/authors", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Set<Author> getAuthors(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
		return authorService.getAuthors(pageNumber, pageSize);
	}
	
}
