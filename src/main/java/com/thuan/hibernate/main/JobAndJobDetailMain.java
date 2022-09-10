package com.thuan.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.JobDetails;
import com.thuan.hibernate.entity.Jobs;
import com.thuan.hibernate.utils.HibernateUtils;

public class JobAndJobDetailMain {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Jobs jobs = new Jobs("JOB001", "Job title 1", 100.0, 500.0);
		Jobs jobs2 = new Jobs("JOB002", "Job title 2", 100.0, 500.0);
		JobDetails details = new JobDetails("jobDescription", LocalDate.of(2022, 10, 10), jobs);
		jobs.setJobDetail(details);

		session.save(jobs);
		session.save(jobs2);
		
		
		session.delete(jobs);
		//session.save(details);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

}
