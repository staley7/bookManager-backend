package com.bookManager.controller;

import org.slf4j.LoggerFactory;

import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bookManager.dto.BookDto;
import com.bookManager.hateoas.BookResourceAssembler;
import com.bookManager.service.BookService;

@RestController()
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	private BookResourceAssembler bookAssembler;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	@CrossOrigin
	@GetMapping(value =  "/books", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resources<BookDto> getBooks(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
		LOGGER.debug("Get Books");
		Set<BookDto> books = bookService.getBooks(pageNumber, pageSize);
		return new Resources<>(bookAssembler.toResources(books), ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BookController.class).getBooks(pageNumber, pageSize)
				).withSelfRel());
	}
	
	@CrossOrigin
	@GetMapping(value = "/book/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } )
	public BookDto getBook(@PathVariable Long id) {
		LOGGER.debug("Get Book "+id);
		return  bookAssembler.toResource(bookService.getBook(id));
	}
	
	@CrossOrigin
	@PutMapping(value = "/book", produces = { MediaType.APPLICATION_JSON_VALUE } )
	public BookDto saveBook(@RequestBody BookDto book) {
		LOGGER.info("Save Book");
		return bookAssembler.toResource(bookService.saveBook(book));
	}
	
}
