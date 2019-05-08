package com.bookManager.service.impl;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.CollectionMapper;
import com.bookManager.dao.model.Collection;
import com.bookManager.dto.CollectionDto;
import com.bookManager.service.CollectionService;

@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	@Qualifier("bookManagerConverter")
	private ConversionService converter;

	@Autowired
	private CollectionMapper collectionMapper;

	@Override
	public Set<CollectionDto> getCollections(Integer page, Integer pageSize) {
		return collectionMapper.findAllCollections().stream()
				.map(collection -> converter.convert(collection, CollectionDto.class)).collect(Collectors.toSet());
	}

	@Override
	public CollectionDto updateCollection(CollectionDto dto) {
		Collection collection = converter.convert(dto, Collection.class);
		collection.setUpdatedBy("SYSTEM"); // TODO
		collection.setUpdateDate(LocalDateTime.now());
		return null;
	}

	@Override
	public CollectionDto getCollection(Long collectionId) {
		return converter.convert(collectionMapper.findCollectionById(collectionId), CollectionDto.class);
	}

	@Override
	public CollectionDto saveCollection(CollectionDto collection) {
		if (collection != null && collection.getCollectionId() != null) {
			return updateCollection(collection);
		} else {
			return createCollection(collection);
		}
	}

	@Override
	public CollectionDto createCollection(CollectionDto dto) {
		Collection collection = converter.convert(dto, Collection.class);
		collection.setCreateDate(LocalDateTime.now());
		collection.setCreatedBy("SYSTEM"); // TODO
		collection.setUpdateDate(collection.getCreateDate());
		collection.setUpdatedBy(collection.getCreatedBy());
		collectionMapper.insertCollection(collection);
		return dto;
	}

}
