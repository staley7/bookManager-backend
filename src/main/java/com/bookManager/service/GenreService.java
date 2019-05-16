package com.bookManager.service;

import java.util.Set;

import com.bookManager.dto.GenreDto;

/**
 * Interface defining all Genre related service level interactions.
 * @author Lance Staley
 *
 */
public interface GenreService {
	
	/**
	 * Returns the given page of genre, based on a pageSize
	 * @param page
	 * @param pageSize
	 * @return Set<GenreDto>
	 */
	Set<GenreDto> getGenres(Integer page, Integer pageSize);
	
	/**
	 * Updates the given Genre
	 * @param genre
	 * @return GenreDto
	 */
	GenreDto updateGenre(GenreDto genre);

	/**
	 * Returns a Genre for the given id.
	 * @return GenreDto
	 */
	GenreDto getGenre(Long genreId);

	/**
	 * Creates a new genre or updates an existing genre
	 * @param genre
	 * @return GenreDto
	 */
	GenreDto saveGenre(GenreDto genre);
	
	/**
	 * Creates a new genre.
	 * @param genre
	 * @return GenreDto
	 */
	GenreDto createGenre(GenreDto genre);
	
	/**
	 * Returns the number of Genre
	 * @return Integer
	 */
	Integer getGenreCount();
}
