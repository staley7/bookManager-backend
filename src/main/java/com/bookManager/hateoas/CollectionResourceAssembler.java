package com.bookManager.hateoas;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bookManager.controller.CollectionController;
import com.bookManager.dto.CollectionDto;

@Component
public class CollectionResourceAssembler extends ResourceAssemblerSupport<CollectionDto, CollectionDto> {

	public CollectionResourceAssembler() {
		super(CollectionController.class, CollectionDto.class);
	}

	@Override
	public CollectionDto toResource(CollectionDto collection) {
		 collection.add(ControllerLinkBuilder
	                .linkTo(ControllerLinkBuilder.methodOn(CollectionController.class).getCollection(collection.getCollectionId())).withSelfRel());
	     return collection;
	}

}
