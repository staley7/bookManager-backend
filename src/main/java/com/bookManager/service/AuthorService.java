package com.bookManager.service;

import java.util.Set;

import com.bookManager.dao.model.Author;

/**
 * Interface defining all Author related service level interactions.
 * @author Lance Staley
 *
 */
public interface AuthorService {

	/**
	 * Returns the given page of authors, based on a pageSize
	 * @param page
	 * @param pageSize
	 * @return Set<Author>
	 */
	Set<Author> getAuthors(Integer page, Integer pageSize);
	
	/**
	 * Returns the Author with the given id.
	 * @param authorId
	 * @return Author
	 */
	Author getAuthor(Long authorId);
	
	/**
	 * Updates the given Author
	 * @param author
	 * @return boolean
	 */
	boolean updateAuthor(Author author);
	
	/**
	 * Deletes the Author with the given id.
	 * @param authorId
	 * @return boolean
	 */
	boolean deleteAuthor(Long authorId);
}
