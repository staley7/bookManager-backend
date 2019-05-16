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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.bookManager.dto.GenreDto;
import com.bookManager.hateoas.GenreResourceAssembler;
import com.bookManager.service.GenreService;

@RestController()
@RequestMapping("/api")
public class GenreController {

	@Autowired
	private GenreService genreService;

	@Autowired
	GenreResourceAssembler genreAssembler;

	private static final Logger LOGGER = LoggerFactory.getLogger(GenreController.class);

	@CrossOrigin
	@GetMapping(value = "/genres", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resources<GenreDto> getGenres(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		Set<GenreDto> genres = genreService.getGenres(pageNumber, pageSize);
		return new Resources<>(genreAssembler.toResources(genres), ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(GenreController.class).getGenres(pageNumber, pageSize)
				).withSelfRel());
	}

	@CrossOrigin
	@PutMapping(value = "/genre", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GenreDto saveGenre(@RequestBody GenreDto genre) {
		LOGGER.info("save genre");
		return genreAssembler.toResource(genreService.saveGenre(genre));
	}

	@CrossOrigin
	@GetMapping(value = "/genre/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GenreDto getGenre(@PathVariable Long id) {
		return genreAssembler.toResource(genreService.getGenre(id));
	}

	@CrossOrigin
	@GetMapping(value = "/genres/count", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Integer getGenre() {
		return genreService.getGenreCount();
	}
	
}
