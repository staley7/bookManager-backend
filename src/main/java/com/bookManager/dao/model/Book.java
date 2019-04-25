package com.bookManager.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A representation of a Book.
 * @author lstaley
 *
 */
public class Book implements Serializable {

	private static final long serialVersionUID = 8595021797013342926L;

	private Long bookId;
	
	private String title;
	
	private String description;
	
	private Double rating;
	
	private Set<Genre> genres;

	private Long authorId;
	
	private Author author;
	
	private LocalDateTime updatedDate;
	
	private LocalDateTime createDate;
	
	private Series series;
	private Collection collection;
	
	
	public Book() {}


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long id) {
		this.bookId = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public Set<Genre> getGenres() {
		return genres;
	}


	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}


	public Long getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public Series getSeries() {
		return series;
	}


	public void setSeries(Series series) {
		this.series = series;
	}


	public Collection getCollection() {
		return collection;
	}


	public void setCollection(Collection collection) {
		this.collection = collection;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}
	
	
	
}
