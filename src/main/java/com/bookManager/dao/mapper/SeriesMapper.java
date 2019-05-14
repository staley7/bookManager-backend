package com.bookManager.dao.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.bookManager.dao.model.Series;

/**
 * Mapper interface for CRUD operations for the Series table.
 * @author Lance Staley
 *
 */
@Mapper
public interface SeriesMapper {

	
	/**
	 * Inserts a new Series into the Series table.
	 * @param Series
	 */
	 public void insertSeries(Series series);
	 
	 /**
	  * Returns the Series with the given id.
	  * @param seriesId
	  * @return Series
	  */
	 public Series findSeriesById(Long seriesId);
	 
	 /**
	  * Returns a Set of all Series
	  * @return Set<Series>
	  */
	 public Set<Series> findAllSeries();
	 
	 /**
	  * Returns the set of Series from given set of parameters.
	  * @param limit
	  * @param offSet
	  * @param sortOrder
	  * @param sortField
	  * @return Set<Series>
	  */
	 public Set<Series> findSeries(Integer limit, Integer offSet, String sortOrder, String sortField);
	 
	 
	 /**
	  * Updates the given Series
	  * @param series
	  */
	 public void updateSeries(Series series);
	 
	 /**
	  * Deletes the Series with the given id.
	  * @param seriesId
	  */
	 public void deleteSeries(Long seriesId);
}
