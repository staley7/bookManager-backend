package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Series;
import com.bookManager.dto.SeriesDto;

/**
 * Converter to convert Series to an SeriesDto object
 * @author Lance Staley
 *
 */
public class SeriesToSeriesDtoConverter implements Converter<Series, SeriesDto> {

	@Override
	public SeriesDto convert(Series series) {
		SeriesDto dto = new SeriesDto();
		dto.setSeriesId(series.getSeriesId());;
		dto.setName(series.getName());
		dto.setDescription(series.getDescription());
		dto.setRating(series.getRating());
		dto.setCreateDate(series.getCreateDate());
		dto.setCreatedBy(series.getCreatedBy());
		dto.setUpdatedDate(series.getUpdateDate());
		dto.setUpdatedBy(series.getUpdatedBy());
		return dto;
	}

}
