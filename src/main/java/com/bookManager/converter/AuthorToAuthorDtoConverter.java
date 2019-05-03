package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Author;
import com.bookManager.dto.AuthorDto;

/**
 * Converter to convert Author to an AuthorDto object
 * @author Lance Staley
 *
 */
public class AuthorToAuthorDtoConverter implements Converter<Author, AuthorDto> {

	@Override
	public AuthorDto convert(Author author) {
		AuthorDto dto = new AuthorDto();
		dto.setAuthorId(author.getAuthorId());
		dto.setFirstName(author.getFirstName());
		dto.setLastName(author.getLastName());
		dto.setRating(author.getRating());
		dto.setCreateDate(author.getCreateDate());
		dto.setCreatedBy(author.getCreatedBy());
		dto.setUpdatedDate(author.getUpdateDate());
		dto.setLastUpdatedBy(author.getLastUpdatedBy());
		return dto;
	}

}
