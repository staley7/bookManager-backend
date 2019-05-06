package com.bookManager.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.BookMapper;
import com.bookManager.dao.model.Book;
import com.bookManager.dto.BookDto;
import com.bookManager.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookManagerConverter")
	private ConversionService converter;
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public BookDto updateBook(BookDto book) {
		bookMapper.updateBook(converter.convert(book, Book.class));
		return book;
	}

	@Override
	public BookDto getBook(Long bookId) {
		return converter.convert(bookMapper.findBookById(bookId), BookDto.class);
	}

	@Override
	public BookDto saveBook(BookDto book) {
		if(book != null) {
			if(book.getBookId() != null) {
				return updateBook(book);
			}else {
				return createBook(book);
			}
		}
		return null;
	}

	@Override
	public Set<BookDto> getBooks(Integer page, Integer pageSize) {
		return this.bookMapper.findAllBooks().stream().map(book -> converter.convert(book, BookDto.class)).collect(Collectors.toSet());
	}

	@Override
	public BookDto createBook(BookDto book) {
		bookMapper.insertBook(converter.convert(book, Book.class));
		return book;
	}
	



}
