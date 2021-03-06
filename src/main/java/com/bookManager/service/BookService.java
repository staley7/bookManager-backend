package com.bookManager.service;

import java.util.Set;

import com.bookManager.dto.BookDto;

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
	 * @param sortOrder
	 * @param sortField
	 * @return Set<Book>
	 */
	Set<BookDto> getBooks(Integer page, Integer pageSize, String sortOrder, String sortField);
	
	/**
	 * Updates the given Book
	 * @param book
	 * @return BookDto
	 */
	BookDto updateBook(BookDto book);

	/**
	 * Returns a BookDto for the given id.
	 * @return BookDto
	 */
	BookDto getBook(Long bookId);

	/**
	 * Creates a new book or updates an existing book
	 * @param book
	 * @return BookDto
	 */
	BookDto saveBook(BookDto book);
	
	/**
	 * Creates a new book.
	 * @param book
	 * @return BookDto
	 */
	BookDto createBook(BookDto book);
	
	/**
	 * Returns the number of Books.
	 * @return Integer, number of Books
	 */
	Integer getBookCount();
}
