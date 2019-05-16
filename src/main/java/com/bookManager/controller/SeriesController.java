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

import com.bookManager.dto.SeriesDto;
import com.bookManager.hateoas.SeriesResourceAssembler;
import com.bookManager.service.SeriesService;

@RestController()
@RequestMapping("/api")
public class SeriesController {

	@Autowired
	private SeriesService seriesService;

	@Autowired
	SeriesResourceAssembler seriesAssembler;

	private static final Logger LOGGER = LoggerFactory.getLogger(SeriesController.class);

	@CrossOrigin
	@GetMapping(value = "/series", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resources<SeriesDto> getSeries(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String sortOrder, @RequestParam(required = false) String sortField) {
		Set<SeriesDto> collections = seriesService.getSeries(pageNumber, pageSize, sortOrder, sortField);
		return new Resources<>(seriesAssembler.toResources(collections), ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(SeriesController.class).getSeries(pageNumber, pageSize, sortOrder, sortField)
				).withSelfRel());
	}

	@CrossOrigin
	@PutMapping(value = "/series", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SeriesDto saveSeries(@RequestBody SeriesDto series) {
		LOGGER.info("save Series");
		return seriesAssembler.toResource(seriesService.saveSeries(series));
	}

	@CrossOrigin
	@GetMapping(value = "/series/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SeriesDto getSeries(@PathVariable Long id) {
		return seriesAssembler.toResource(seriesService.getSeries(id));
	}
	
	@CrossOrigin
	@GetMapping(value = "/series/count", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Integer getSeriesCount() {
		return seriesService.getSeriesCount();
	}

}
