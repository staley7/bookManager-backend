package com.bookManager.dao.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.bookManager.dao.model.Genre;

/**
 * Mapper interface for CRUD operations for the Genre table.
 * @author Lance Staley
 *
 */
@Mapper
public interface GenreMapper {

	
	/**
	 * Inserts a new Genre into the Genre table.
	 * @param genre
	 */
	 public void insertGenre(Genre genre);
	 
	 /**
	  * Returns the Genre with the given id.
	  * @param genreId
	  * @return Genre
	  */
	 public Genre findGenreById(Long genreId);
	 
	 /**
	  * Returns a Set of all Genre
	  * @return Set<Genre>
	  */
	 public Set<Genre> findAllGenres();
	 
	 /**
	  * Updates the given Genre
	  * @param genre
	  */
	 public void updateGenre(Genre genre);
	 
	 /**
	  * Deletes the Genre with the given id.
	  * @param genreId
	  */
	 public void deleteGenre(Long genreId);
}
