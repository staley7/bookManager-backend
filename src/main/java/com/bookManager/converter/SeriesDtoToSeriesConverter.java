package com.bookManager.converter;

import org.springframework.core.convert.converter.Converter;

import com.bookManager.dao.model.Series;
import com.bookManager.dto.SeriesDto;

/**
 * Converts a SeriesDto to a Series
 * @author Lance Staley
 *
 */
public class SeriesDtoToSeriesConverter implements Converter<SeriesDto, Series> {

	@Override
	public Series convert(SeriesDto dto) {
		Series series = new Series();
		series.setName(dto.getName());
		series.setSeriesId(dto.getSeriesId());
		if(dto.getAuthor() != null) {
			series.setAuthorId(dto.getAuthor().getAuthorId());
		}else {
			series.setAuthorId(dto.getAuthorId());
		}
		series.setDescription(dto.getDescription());
		series.setRating(dto.getRating());
		series.setCreateDate(dto.getCreateDate());
		series.setCreatedBy(dto.getCreatedBy());
		series.setUpdateDate(dto.getUpdatedDate());
		series.setUpdatedBy(dto.getUpdatedBy());
		return series;
	}

	
}
