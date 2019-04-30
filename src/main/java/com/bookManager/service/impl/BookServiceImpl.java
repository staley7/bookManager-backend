package com.bookManager.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.bookManager.dao.model.Book;
import com.bookManager.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Override
	public Set<Book> getBooks(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}



}
