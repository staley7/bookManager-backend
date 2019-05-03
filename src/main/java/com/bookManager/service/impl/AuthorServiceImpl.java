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
		// TODO
		/*
		 * Set<Author> authors = new HashSet<>(); Author one = new Author();
		 * one.setAuthorId(1L); one.setFirstName("JK"); one.setLastName("Rowling");
		 * one.setRating(9.5); one.setCreateDate(LocalDateTime.now()); authors.add(one);
		 * 
		 * Author two = new Author(); two.setAuthorId(2L); two.setFirstName("Patrick");
		 * two.setLastName("Rothfuss"); two.setRating(9.5);
		 * two.setCreateDate(LocalDateTime.now()); authors.add(two);
		 * 
		 * Author three = new Author(); three.setAuthorId(3L);
		 * three.setFirstName("R.A."); three.setLastName("Salavatore");
		 * three.setRating(9.5); three.setCreateDate(LocalDateTime.now());
		 * authors.add(three);
		 * 
		 * Author four = new Author(); four.setAuthorId(14L);
		 * four.setFirstName("Miles"); four.setLastName("Cameron"); four.setRating(9.5);
		 * four.setCreateDate(LocalDateTime.now()); authors.add(four);
		 * 
		 * Author five = new Author(); five.setAuthorId(25L);
		 * five.setFirstName("Steve"); five.setLastName("Erickson");
		 * five.setRating(9.5); five.setCreateDate(LocalDateTime.now());
		 * authors.add(five);
		 * 
		 * Author six = new Author(); six.setAuthorId(6L); six.setFirstName("Dan");
		 * six.setLastName("Brown"); six.setRating(8.0);
		 * six.setCreateDate(LocalDateTime.now()); authors.add(six);
		 * 
		 * Author seven = new Author(); seven.setAuthorId(7L);
		 * seven.setFirstName("Terry"); seven.setLastName("Brooks");
		 * seven.setRating(7.5); seven.setCreateDate(LocalDateTime.now());
		 * authors.add(seven);
		 * 
		 * Author eight = new Author(); eight.setAuthorId(8L);
		 * eight.setFirstName("John"); eight.setLastName("Doe"); eight.setRating(9.5);
		 * eight.setCreateDate(LocalDateTime.now()); authors.add(eight);
		 * 
		 * Author nine = new Author(); nine.setAuthorId(3L); nine.setFirstName("Jan.");
		 * nine.setLastName("Austin"); nine.setRating(9.5);
		 * nine.setCreateDate(LocalDateTime.now()); authors.add(nine);
		 * 
		 * Author ten = new Author(); ten.setAuthorId(10L); ten.setFirstName("Clark");
		 * ten.setLastName("kent"); ten.setRating(9.5);
		 * ten.setCreateDate(LocalDateTime.now()); authors.add(ten);
		 * 
		 * if (page != null && pageSize != null) { int pageStartInd = pageSize * page;
		 * List<Author> author = new ArrayList<>(authors); return new
		 * HashSet<>(author.subList(pageStartInd, pageStartInd + pageSize)); } else {
		 * return authors; }
		 */

		return this.authorMapper.findAllAuthors().stream().map(author -> converter.convert(author, AuthorDto.class))
				.collect(Collectors.toSet());
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
