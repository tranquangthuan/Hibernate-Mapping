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
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String phone;

	@OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PublisherBook> publisherBooks;

	public Publisher() {
		super();
	}

	public Publisher(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<PublisherBook> getPublisherBooks() {
		return publisherBooks;
	}

	public void setPublisherBooks(List<PublisherBook> publisherBooks) {
		this.publisherBooks = publisherBooks;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
