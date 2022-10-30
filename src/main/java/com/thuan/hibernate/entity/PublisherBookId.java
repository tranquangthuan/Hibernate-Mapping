package com.thuan.hibernate.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PublisherBookId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int publisherId;
	private int bookId;

	public PublisherBookId() {
		super();
	}

	public PublisherBookId(int publisherId, int bookId) {
		super();
		this.publisherId = publisherId;
		this.bookId = bookId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, publisherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublisherBookId other = (PublisherBookId) obj;
		return bookId == other.bookId && publisherId == other.publisherId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
