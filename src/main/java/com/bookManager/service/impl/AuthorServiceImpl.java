package com.bookManager.service.impl;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.AuthorMapper;
import com.bookManager.dao.model.Author;
import com.bookManager.dto.AuthorDto;
import com.bookManager.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	@Qualifier("bookManagerConverter")
	private ConversionService converter;

	@Autowired
	private AuthorMapper authorMapper;

	@Override
	public Set<AuthorDto> getAuthors(Integer page, Integer pageSize) {
		Integer offSet = this.authorMapper.findAuthorCount()/pageSize;
		return this.authorMapper.findPagedAuthors(pageSize, offSet).stream().map(author -> converter.convert(author, AuthorDto.class)).collect(Collectors.toSet());
	}

	@Override
	public AuthorDto getAuthor(Long authorId) {
		Author author = this.authorMapper.findAuthorById(authorId);
		return converter.convert(author, AuthorDto.class);
	}

	@Override
	public boolean deleteAuthor(Long authorId) {
		this.authorMapper.deleteAuthor(authorId);
		return true;
	}

	@Override
	public AuthorDto updateAuthor(AuthorDto dto) {
		Author author = converter.convert(dto, Author.class);
		author.setUpdateDate(LocalDateTime.now());
		author.setLastUpdatedBy("SYSTEM"); //TODO replace with logged in in user
		this.authorMapper.updateAuthor(author);
		return dto;
	}

	@Override
	public AuthorDto saveAuthor(AuthorDto author) {
		if (author != null) {
			if (author.getAuthorId() != null) {
				return updateAuthor(author);
			} else {
				return createAuthor(author);
			}
		}
		return null;
	}

	@Override
	public AuthorDto createAuthor(AuthorDto dto) {
		Author author = converter.convert(dto, Author.class);
		author.setUpdateDate(LocalDateTime.now());
		author.setCreateDate(LocalDateTime.now());
		author.setLastUpdatedBy("SYSTEM"); //TODO replace with logged in in user
		author.setCreatedBy(author.getLastUpdatedBy());
		this.authorMapper.insertAuthor(author);
		return dto;
	}

}
