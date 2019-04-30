package com.bookManager.dao.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.bookManager.dao.model.Author;

/**
 * Mapper interface for CRUD operations for the Author table.
 * @author Lance Staley
 *
 */
@Mapper
public interface AuthorMapper {

	
	/**
	 * Inserts a new Author into the Author table.
	 * @param author
	 */
	 public void insertAuthor(Author author);
	 
	 /**
	  * Returns the Author with the given id.
	  * @param authorId
	  * @return Author
	  */
	 public Author findAuthorById(Long authorId);
	 
	 /**
	  * Returns a Set of all Authors
	  * @return Set<Author>
	  */
	 public Set<Author> findAllAuthors();
	 
	 /**
	  * Updates the given Author
	  * @param author
	  */
	 public void updateAuthor(Author author);
	 
	 /**
	  * Deletes the Author with the given id.
	  * @param authorId
	  */
	 public void deleteAuthor(Long authorId);
}
