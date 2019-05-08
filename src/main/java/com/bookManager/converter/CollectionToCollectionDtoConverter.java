package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Collection;
import com.bookManager.dto.CollectionDto;

/**
 * Converter to convert Collection to an CollectionDto object
 * @author Lance Staley
 *
 */
public class CollectionToCollectionDtoConverter implements Converter<Collection, CollectionDto> {

	@Override
	public CollectionDto convert(Collection collection) {
		CollectionDto dto = new CollectionDto();
		dto.setCollectionId(collection.getCollectionId());
		dto.setName(collection.getName());
		dto.setDescription(collection.getDescription());
		dto.setRating(collection.getRating());
		dto.setCreateDate(collection.getCreateDate());
		dto.setCreatedBy(collection.getCreatedBy());
		dto.setUpdatedDate(collection.getUpdateDate());
		dto.setLastUpdatedBy(collection.getUpdatedBy());
		return dto;
	}

}
