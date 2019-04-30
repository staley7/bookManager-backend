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
import com.bookManager.dao.model.Book;
import com.bookManager.service.BookService;

@RestController()
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService authorService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	//TODO
	@CrossOrigin
	@RequestMapping(value =  "/books", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Set<Book> getBooks(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
		return authorService.getBooks(pageNumber, pageSize);
	}
	
}
