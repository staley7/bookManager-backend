package com.bookManager.hateoas;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bookManager.controller.BookController;
import com.bookManager.dto.BookDto;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<BookDto, BookDto> {

	public BookResourceAssembler() {
		super(BookController.class, BookDto.class);
	}

	@Override
	public BookDto toResource(BookDto book) {
		 book.add(ControllerLinkBuilder
	                .linkTo(ControllerLinkBuilder.methodOn(BookController.class).getBook(book.getBookId())).withSelfRel());
	     return book;
	}

}
