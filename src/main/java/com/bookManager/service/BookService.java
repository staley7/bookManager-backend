package com.bookManager.service;

import java.util.Set;

import com.bookManager.dao.model.Book;

/**
 * Interface defining all Book related service level interactions.
 * @author Lance Staley
 *
 */
public interface BookService {
	
	/**
	 * Returns the given page of books, based on a pageSize
	 * @param page
	 * @param pageSize
	 * @return Set<Book>
	 */
	Set<Book> getBooks(Integer page, Integer pageSize);
	
	/**
	 * Updates the given Book
	 * @param book
	 * @return boolean
	 */
	boolean updateBook(Book book);
}
