package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Book;
import com.bookManager.dto.BookDto;

/**
 * Converter to convert Book to an BookDto object
 * @author Lance Staley
 *
 */
public class BookToBookDtoConverter implements Converter<Book, BookDto> {

	@Override
	public BookDto convert(Book book) {
		BookDto dto = new BookDto();
		dto.setAuthorId(book.getAuthorId());
		dto.setBookId(book.getBookId());
		dto.setTitle(book.getTitle());
		dto.setDescription(book.getDescription());
		dto.setRating(book.getRating());
		dto.setCreateDate(book.getCreateDate());
		dto.setCreatedBy(book.getCreatedBy());
		dto.setUpdatedDate(book.getUpdateDate());
		dto.setLastUpdatedBy(book.getLastUpdatedBy());
		return dto;
	}

}
