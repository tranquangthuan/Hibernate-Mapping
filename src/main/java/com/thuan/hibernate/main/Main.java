package com.thuan.hibernate.main;

import org.hibernate.SessionFactory;

import com.thuan.hibernate.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		System.out.println("DB Create");
	}

}
