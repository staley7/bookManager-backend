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

import com.bookManager.dto.CollectionDto;
import com.bookManager.hateoas.CollectionResourceAssembler;
import com.bookManager.service.CollectionService;

@RestController()
@RequestMapping("/api")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;

	@Autowired
	CollectionResourceAssembler collectionAssembler;

	private static final Logger LOGGER = LoggerFactory.getLogger(CollectionController.class);

	@CrossOrigin
	@GetMapping(value = "/collections", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resources<CollectionDto> getAuthors(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		Set<CollectionDto> collections = collectionService.getCollections(pageNumber, pageSize);
		return new Resources<>(collectionAssembler.toResources(collections), ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CollectionController.class).getAuthors(pageNumber, pageSize)
				).withSelfRel());
	}

	@CrossOrigin
	@PutMapping(value = "/collection", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CollectionDto saveCollection(@RequestBody CollectionDto collection) {
		LOGGER.info("save Collection");
		return collectionAssembler.toResource(collectionService.saveCollection(collection));
	}

	@CrossOrigin
	@GetMapping(value = "/collection/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CollectionDto getCollection(@PathVariable Long id) {
		return collectionAssembler.toResource(collectionService.getCollection(id));
	}

}
