package com.bookManager.dao.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.bookManager.dao.model.Book;

/**
 * Mapper interface for CRUD operations for the Author table.
 * @author Lance Staley
 *
 */
@Mapper
public interface BookMapper {

	
	/**
	 * Inserts a new Book into the Book table.
	 * @param book
	 */
	 public void insertBook(Book book);
	 
	 /**
	  * Returns the book with the given id.
	  * @param bookId
	  * @return Book
	  */
	 public Book findBookById(Long bookId);
	 
	 /**
	  * Returns a Set of all Books
	  * @return Set<Book>
	  */
	 public Set<Book> findAllBooks();
	 
	 /**
	  * Returns a Set of Books with the given limit, offset, sortOrder, sortField
	  * @param limit
	  * @param offSet
	  * @param sortOrder
	  * @param sortField
	  * @return Set<Book>
	  */
	 public Set<Book> findBooks(Integer limit, Integer offSet, String sortOrder, String sortField);
	 
	 /**
	  * Updates the given Book
	  * @param book
	  */
	 public void updateBook(Book book);
	 
	 /**
	  * Deletes the Book with the given id.
	  * @param bookId
	  */
	 public void deleteBook(Long bookId);
	 
	 /**
	  * Returns the number of Books
	  * @return int, the number of Books
	  */
	 public int findBookCount();
}
