package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Author;
import com.bookManager.dto.AuthorDto;

/**
 * Converts a AuthorDto to an Author
 * @author Lance Staley
 *
 */
public class AuthorDtoToAuthorConverter implements Converter<AuthorDto, Author> {

	@Override
	public Author convert(AuthorDto dto) {
		Author author = new Author();
		author.setAuthorId(dto.getAuthorId());
		author.setFirstName(dto.getFirstName());
		author.setLastName(dto.getLastName());
		author.setRating(dto.getRating());
		author.setCreateDate(dto.getCreateDate());
		author.setCreatedBy(dto.getCreatedBy());
		author.setUpdateDate(dto.getUpdatedDate());
		author.setLastUpdatedBy(dto.getLastUpdatedBy());
		return author;
	}

	
}
