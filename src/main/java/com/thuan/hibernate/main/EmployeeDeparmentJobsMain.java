package com.thuan.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.entity.Job;
import com.thuan.hibernate.entity.JobDetails;
import com.thuan.hibernate.utils.HibernateUtils;

public class EmployeeDeparmentJobsMain {

	public static void main(String[] args) {
		insertData();
		SelectEmployeeMain.selectDeparment(1);
	}

	private static void insertData() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// insert Department
		Department department = new Department("IT");
		session.save(department);

		// insert Job and Jobs Detail
		Job job = new Job("Job title 1", 100.0, 500.0);
		JobDetails details = new JobDetails("jobDescription", LocalDate.of(2022, 10, 10), job);
		job.setJobDetail(details);
		session.save(job);

		// Insert Employee with Department and Job
		Employee emp1 = new Employee("Thuan", (byte) 35, 1000, "Dev", "VN");
		Employee emp2 = new Employee("Anh", (byte) 20, 2000, "Dev", "VN");

		emp1.setDepartment(department);
		emp1.setJob(job);
		emp2.setDepartment(department);
		emp2.setJob(job);
		session.save(emp1);
		session.save(emp2);

		t.commit();
		System.out.println("successfully saved");

		factory.close();
		session.close();
	}

}
