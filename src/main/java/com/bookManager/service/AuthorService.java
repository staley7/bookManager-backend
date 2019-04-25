package com.bookManager.service;

import java.util.Set;

import com.bookManager.dao.model.Author;

public interface AuthorService {

	Set<Author> getAuthors(Integer page, Integer pageSize);
	
}
