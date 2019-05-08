package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Collection;
import com.bookManager.dto.CollectionDto;

/**
 * Converts a CollectionDto to a Collection
 * @author Lance Staley
 *
 */
public class CollectionDtoToCollectionConverter implements Converter<CollectionDto, Collection> {

	@Override
	public Collection convert(CollectionDto dto) {
		Collection collection = new Collection();
		collection.setName(dto.getName());
		collection.setCollectionId(dto.getCollectionId());
		collection.setDescription(dto.getDescription());
		collection.setRating(dto.getRating());
		collection.setCreateDate(dto.getCreateDate());
		collection.setCreatedBy(dto.getCreatedBy());
		collection.setUpdateDate(dto.getUpdatedDate());
		collection.setUpdatedBy(dto.getLastUpdatedBy());
		return collection;
	}

	
}
