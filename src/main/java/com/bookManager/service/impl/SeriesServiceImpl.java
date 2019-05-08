package com.bookManager.service.impl;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.bookManager.dao.mapper.SeriesMapper;
import com.bookManager.dao.model.Series;
import com.bookManager.dto.SeriesDto;
import com.bookManager.service.SeriesService;

@Service("seriesService")
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	@Qualifier("bookManagerConverter")
	private ConversionService converter;

	@Autowired
	private SeriesMapper seriesMapper;

	@Override
	public Set<SeriesDto> getSeries(Integer page, Integer pageSize) {
		return seriesMapper.findAllSeries().stream()
				.map(collection -> converter.convert(collection, SeriesDto.class)).collect(Collectors.toSet());
	}

	@Override
	public SeriesDto updateSeries(SeriesDto dto) {
		Series series = converter.convert(dto, Series.class);
		series.setUpdatedBy("SYSTEM"); // TODO
		series.setUpdateDate(LocalDateTime.now());
		return null;
	}

	@Override
	public SeriesDto getSeries(Long seriesId) {
		return converter.convert(seriesMapper.findSeriesById(seriesId), SeriesDto.class);
	}

	@Override
	public SeriesDto saveSeries(SeriesDto series) {
		if (series != null && series.getSeriesId() != null) {
			return updateSeries(series);
		} else {
			return createSeries(series);
		}
	}

	@Override
	public SeriesDto createSeries(SeriesDto dto) {
		Series series = converter.convert(dto, Series.class);
		series.setCreateDate(LocalDateTime.now());
		series.setCreatedBy("SYSTEM"); // TODO
		series.setUpdateDate(series.getCreateDate());
		series.setUpdatedBy(series.getCreatedBy());
		seriesMapper.insertSeries(series);
		return dto;
	}


}
