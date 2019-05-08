package com.bookManager.hateoas;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bookManager.controller.GenreController;
import com.bookManager.dto.GenreDto;

@Component
public class GenreResourceAssembler extends ResourceAssemblerSupport<GenreDto, GenreDto> {

	public GenreResourceAssembler() {
		super(GenreController.class, GenreDto.class);
	}

	@Override
	public GenreDto toResource(GenreDto genre) {
		genre.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(GenreController.class).getGenre(genre.getGenreId()))
				.withSelfRel());
		return genre;
	}
}
