package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Book;
import com.bookManager.dto.BookDto;

/**
 * Converts a BookDto to an Book
 * @author Lance Staley
 *
 */
public class BookDtoToBookConverter implements Converter<BookDto, Book> {

	@Override
	public Book convert(BookDto dto) {
		Book book = new Book();
		if(dto.getAuthorId() == null && dto.getAuthor() != null) {
			book.setAuthorId(dto.getAuthor().getAuthorId());
		}else {
			book.setAuthorId(dto.getAuthorId());
		}
		book.setBookId(dto.getBookId());
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		book.setCreateDate(dto.getCreateDate());
		book.setCreatedBy(dto.getCreatedBy());
		book.setUpdateDate(dto.getUpdatedDate());
		book.setLastUpdatedBy(dto.getLastUpdatedBy());
		return book;
	}

	
}
