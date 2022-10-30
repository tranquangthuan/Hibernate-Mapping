package com.thuan.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private int year;

	private String version;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PublisherBook> publisherBooks;

	public Book() {
		super();
	}

	public Book(String title, int year, String version) {
		super();
		this.title = title;
		this.year = year;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<PublisherBook> getPublisherBooks() {
		return publisherBooks;
	}

	public void setPublisherBooks(List<PublisherBook> publisherBooks) {
		this.publisherBooks = publisherBooks;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", year=" + year + ", version=" + version + "]";
	}

}
