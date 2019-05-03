package com.bookManager.hateoas;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bookManager.controller.AuthorController;
import com.bookManager.dto.AuthorDto;

@Component
public class AuthorResourceAssembler extends ResourceAssemblerSupport<AuthorDto, AuthorDto> {

	public AuthorResourceAssembler() {
		super(AuthorController.class, AuthorDto.class);
	}

	@Override
	public AuthorDto toResource(AuthorDto author) {
		 author.add(ControllerLinkBuilder
	                .linkTo(ControllerLinkBuilder.methodOn(AuthorController.class).getAuthor(author.getAuthorId())).withSelfRel());
	     return author;
	}

}
