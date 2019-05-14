package com.bookManager.service.impl;

import java.time.LocalDateTime;
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
	public BookDto updateBook(BookDto dto) {
		Book book = converter.convert(dto, Book.class);
		book.setUpdateDate(LocalDateTime.now());
		book.setLastUpdatedBy("SYSTEM"); //TODO
		bookMapper.updateBook(book);
		return dto;
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
	public Set<BookDto> getBooks(Integer page, Integer pageSize, String sortOrder, String sortField) {
		Integer offSet = null;
		if(pageSize != null && page != null) {
		 offSet = pageSize*page;
		}
		return this.bookMapper.findBooks(pageSize, offSet, sortOrder, sortField).stream().map(book -> converter.convert(book, BookDto.class)).collect(Collectors.toSet());
	}

	@Override
	public BookDto createBook(BookDto dto) {
		Book book = converter.convert(dto, Book.class);
		book.setCreateDate(LocalDateTime.now());
		book.setCreatedBy("SYSTEM"); //TODO update to actual user.
		book.setUpdateDate(book.getCreateDate());
		book.setLastUpdatedBy(book.getCreatedBy());
		bookMapper.insertBook(book);
		return dto;
	}
	



}
