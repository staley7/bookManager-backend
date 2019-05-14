package com.bookManager.service;

import java.util.Set;

import com.bookManager.dto.AuthorDto;

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
	 * @param sortOrder, order to sort the results in. ASC or DESC.
	 * @param sortField, field to sort the result by.
	 * @return Set<Author>
	 */
	Set<AuthorDto> getAuthors(Integer page, Integer pageSize, String sortOrder, String sortField);
	
	/**
	 * Returns the Author with the given id.
	 * @param authorId
	 * @return Author
	 */
	AuthorDto getAuthor(Long authorId);
	
	/**
	 * Updates the given Author
	 * @param author
	 * @return boolean
	 */
	AuthorDto updateAuthor(AuthorDto author);
	
	/**
	 * Creates a new Author.
	 * @param author
	 * @return AuthorDto
	 */
	AuthorDto createAuthor(AuthorDto author);
	
	/**
	 * Updates and existing author and creates a new Author.
	 * @param author
	 * @return AuthorDto
	 */
	AuthorDto saveAuthor(AuthorDto author);
	
	/**
	 * Deletes the Author with the given id.
	 * @param authorId
	 * @return boolean
	 */
	boolean deleteAuthor(Long authorId);
}
