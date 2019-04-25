package com.bookManager.dto;

import org.springframework.hateoas.core.Relation;

/**
 * The DTO for a collection of Authors
 * @author lstaley
 *
 */
@Relation(collectionRelation="authors")
public class AuthorsDto {
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Double rating;
	
	
	
	
}
