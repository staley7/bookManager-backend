package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Genre;
import com.bookManager.dto.GenreDto;

/**
 * Converts a GenreDto to a Genre
 * @author Lance Staley
 *
 */
public class GenreDtoToGenreConverter implements Converter<GenreDto, Genre> {

	@Override
	public Genre convert(GenreDto dto) {
		Genre genre = new Genre();
		genre.setName(dto.getName());
		genre.setGenreId(dto.getGenreId());
		genre.setDescription(dto.getDescription());
		genre.setCreateDate(dto.getCreateDate());
		genre.setCreatedBy(dto.getCreatedBy());
		genre.setUpdatedDate(dto.getUpdatedDate());
		genre.setUpdatedBy(dto.getUpdatedBy());
		return genre;
	}

	
}
