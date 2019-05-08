package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Genre;
import com.bookManager.dto.GenreDto;

/**
 * Converter to convert Genre to an GenreDto object
 * @author Lance Staley
 *
 */
public class GenreToGenreDtoConverter implements Converter<Genre, GenreDto> {

	@Override
	public GenreDto convert(Genre genre) {
		GenreDto dto = new GenreDto();
		dto.setGenreId(genre.getGenreId());;
		dto.setName(genre.getName());
		dto.setDescription(genre.getDescription());
		dto.setCreateDate(genre.getCreateDate());
		dto.setCreatedBy(genre.getCreatedBy());
		dto.setUpdatedDate(genre.getUpdatedDate());
		dto.setUpdatedBy(genre.getUpdatedBy());
		return dto;
	}

}
