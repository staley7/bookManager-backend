package com.bookManager.service;

import java.util.Set;

import com.bookManager.dto.CollectionDto;

/**
 * Interface defining all Collection related service level interactions.
 * @author Lance Staley
 *
 */
public interface CollectionService {
	
	/**
	 * Returns the given page of collections, based on a pageSize
	 * @param page
	 * @param pageSize
	 * @return Set<Collection>
	 */
	Set<CollectionDto> getCollections(Integer page, Integer pageSize);
	
	/**
	 * Updates the given Collection
	 * @param collection
	 * @return CollectionDto
	 */
	CollectionDto updateCollection(CollectionDto collection);

	/**
	 * Returns a CollectionDto for the given id.
	 * @return CollectionDto
	 */
	CollectionDto getCollection(Long collectionId);

	/**
	 * Creates a new collection or updates an existing collection
	 * @param collection
	 * @return CollectionDto
	 */
	CollectionDto saveCollection(CollectionDto collection);
	
	/**
	 * Creates a new collection.
	 * @param collection
	 * @return CollectionDto
	 */
	CollectionDto createCollection(CollectionDto collection);
	
	/**
	 * Returns the  number of Collection entries.
	 * @return Integer
	 */
	Integer getCollectionCount();
}
