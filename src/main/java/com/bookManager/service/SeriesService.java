package com.bookManager.service;

import java.util.Set;

import com.bookManager.dto.SeriesDto;

/**
 * Interface defining all Series related service level interactions.
 * @author Lance Staley
 *
 */
public interface SeriesService {
	
	/**
	 * Returns the given page of series, based on a pageSize
	 * @param page
	 * @param pageSize
	 * @return Set<SeriesDto>
	 */
	Set<SeriesDto> getSeries(Integer page, Integer pageSize);
	
	/**
	 * Updates the given Series
	 * @param series
	 * @return SeriesDto
	 */
	SeriesDto updateSeries(SeriesDto series);

	/**
	 * Returns a SeriesDto for the given id.
	 * @return SeriesDto
	 */
	SeriesDto getSeries(Long seriesId);

	/**
	 * Creates a new series or updates an existing series
	 * @param series
	 * @return SeriesDto
	 */
	SeriesDto saveSeries(SeriesDto series);
	
	/**
	 * Creates a new series.
	 * @param series
	 * @return SeriesDto
	 */
	SeriesDto createSeries(SeriesDto series);
}
