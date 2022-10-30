package com.thuan.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Book;
import com.thuan.hibernate.entity.Publisher;
import com.thuan.hibernate.entity.PublisherBook;
import com.thuan.hibernate.utils.HibernateUtils;

public class BookAndPuslisher {

	public static void main(String[] args) {
		insert();
		selectBook(1);
	}

	private static void insert() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Book book1 = new Book("Book 1", 2022, "V1");
		Book book2 = new Book("Book 2", 2020, "V1");

		Publisher p1 = new Publisher("NXB Kim Dong", "099999");
		Publisher p2 = new Publisher("NXB Tre", "011111");

		// save book
		session.save(book1);
		session.save(book2);

		// save Publisher
		session.save(p1);
		session.save(p2);

		PublisherBook pb1 = new PublisherBook(p1, book1, "Book1-NXB Kim Dong");
		PublisherBook pb2 = new PublisherBook(p2, book1, "Book1-NXB Tre");
		PublisherBook pb3 = new PublisherBook(p1, book2, "Book2-NXB Kim Dong");

		// save PublisherBook
		session.save(pb1);
		session.save(pb2);
		session.save(pb3);

		t.commit();
		System.out.println("successfully saved");

		session.close();
	}

	public static void selectBook(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		System.out.println("Find Book Information");
		Book book = session.find(Book.class, id);
		System.out.println(book);
		System.out.println("PublisherBook =============: Get detail publisher Books");
		List<PublisherBook> publisherBooks = book.getPublisherBooks();
		publisherBooks.forEach(pb -> System.out.println(pb.getFormat() + " " + pb.getPublisher().getName()));
		session.close();
	}

}
