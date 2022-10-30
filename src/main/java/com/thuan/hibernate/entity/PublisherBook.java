package com.thuan.hibernate.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PublisherBook {

	@EmbeddedId
	private PublisherBookId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("bookId")
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("publisherId")
	private Publisher publisher;

	private String format;

	public PublisherBook() {
		super();
	}

	public PublisherBook(Publisher publisher, Book book, String format) {
		super();
		this.publisher = publisher;
		this.book = book;
		this.format = format;
		this.id = new PublisherBookId(publisher.getId(), book.getId());
	}

	public PublisherBook(String format) {
		super();
		this.format = format;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "PublisherBook [id=" + id + ", format=" + format + "]";
	}

}
