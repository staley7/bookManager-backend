package com.bookManager.hateoas;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bookManager.controller.SeriesController;
import com.bookManager.dto.SeriesDto;

@Component
public class SeriesResourceAssembler extends ResourceAssemblerSupport<SeriesDto, SeriesDto> {

	public SeriesResourceAssembler() {
		super(SeriesController.class, SeriesDto.class);
	}

	@Override
	public SeriesDto toResource(SeriesDto series) {
		series.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(SeriesController.class).getSeries(series.getSeriesId()))
				.withSelfRel());
		return series;
	}
}
