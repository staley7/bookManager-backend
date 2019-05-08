package com.bookManager.service.impl;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.GenreMapper;
import com.bookManager.dao.model.Genre;
import com.bookManager.dto.GenreDto;
import com.bookManager.service.GenreService;

@Service("genreService")
public class GenreServiceImpl implements GenreService {

	@Autowired
	@Qualifier("bookManagerConverter")
	private ConversionService converter;

	@Autowired
	private GenreMapper genreMapper;

	@Override
	public Set<GenreDto> getGenres(Integer page, Integer pageSize) {
		return genreMapper.findAllGenres().stream()
				.map(collection -> converter.convert(collection, GenreDto.class)).collect(Collectors.toSet());
	}

	@Override
	public GenreDto updateGenre(GenreDto dto) {
		Genre genre = converter.convert(dto, Genre.class);
		genre.setUpdatedBy("SYSTEM"); // TODO
		genre.setUpdatedDate(LocalDateTime.now());
		return null;
	}

	@Override
	public GenreDto getGenre(Long genreId) {
		return converter.convert(genreMapper.findGenreById(genreId), GenreDto.class);
	}

	@Override
	public GenreDto saveGenre(GenreDto genre) {
		if (genre != null && genre.getGenreId() != null) {
			return updateGenre(genre);
		} else {
			return createGenre(genre);
		}
	}

	@Override
	public GenreDto createGenre(GenreDto dto) {
		Genre genre = converter.convert(dto, Genre.class);
		genre.setCreateDate(LocalDateTime.now());
		genre.setCreatedBy("SYSTEM"); // TODO
		genre.setUpdatedDate(genre.getCreateDate());
		genre.setUpdatedBy(genre.getCreatedBy());
		genreMapper.insertGenre(genre);
		return dto;
	}


}
