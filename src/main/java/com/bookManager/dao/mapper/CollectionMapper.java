package com.bookManager.dao.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.bookManager.dao.model.Collection;

/**
 * Mapper interface for CRUD operations for the Collection table.
 * @author Lance Staley
 *
 */
@Mapper
public interface CollectionMapper {

	
	/**
	 * Inserts a new Collection into the Collection table.
	 * @param Collection
	 */
	 public void insertCollection(Collection collection);
	 
	 /**
	  * Returns the Collection with the given id.
	  * @param collectionId
	  * @return Collection
	  */
	 public Collection findCollectionById(Long collectionId);
	 
	 /**
	  * Returns a Set of all Collections
	  * @return Set<Collection>
	  */
	 public Set<Collection> findAllCollections();
	 
	 /**
	  * Updates the given Collection
	  * @param collection
	  */
	 public void updateCollection(Collection collection);
	 
	 /**
	  * Deletes the Collection with the given id.
	  * @param collectionId
	  */
	 public void deleteCollection(Long collectionId);
	 
	 /**
	  * Returns the number of Collection entries.
	  * @return Integer
	  */
	 public Integer findCollectionCount();
}
