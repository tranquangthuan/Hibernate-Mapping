package com.thuan.hibernate.main;

import org.hibernate.SessionFactory;

import com.thuan.hibernate.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		System.out.println("DB Create");
		factory.close();
	}

}
