package com.bookManager.controller;

import org.slf4j.LoggerFactory;

import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.bookManager.dto.AuthorDto;
import com.bookManager.hateoas.AuthorResourceAssembler;
import com.bookManager.service.AuthorService;

@RestController()
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	AuthorResourceAssembler authorAssembler;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

	@CrossOrigin
	@GetMapping(value = "/authors", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resources<AuthorDto> getAuthors(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		Set<AuthorDto> authors = authorService.getAuthors(pageNumber, pageSize);
		return new Resources<>(authorAssembler.toResources(authors), ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AuthorController.class).getAuthors(pageNumber, pageSize)
				).withSelfRel());
	}

	@CrossOrigin
	@PutMapping(value = "/author", produces = { MediaType.APPLICATION_JSON_VALUE })
	public AuthorDto saveAuthor(@RequestBody AuthorDto author) {
		LOGGER.info("save Author");
		return authorAssembler.toResource(authorService.saveAuthor(author));
	}

	@CrossOrigin
	@GetMapping(value = "/author/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public AuthorDto getAuthor(@PathVariable Long id) {
		return authorAssembler.toResource(authorService.getAuthor(id));
	}

}
