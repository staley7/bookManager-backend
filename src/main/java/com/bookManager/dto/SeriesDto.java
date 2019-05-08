package com.bookManager.dto;

import java.time.LocalDateTime;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

@Relation(collectionRelation = "books")
public class SeriesDto extends ResourceSupport {

	@JsonProperty("id")
	private Long bookId;

	private String description;

	private String title;

	private Double rating;

	private Long authorId;
	
	private AuthorDto author;
	
	private String lastUpdatedBy;

	private String createdBy;

	private LocalDateTime createDate;

	private LocalDateTime updatedDate;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeriesDto other = (SeriesDto) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	
	
}
