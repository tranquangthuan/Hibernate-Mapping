package com.thuan.hibernate.main;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.entity.Job;
import com.thuan.hibernate.entity.JobDetails;
import com.thuan.hibernate.entity.Project;
import com.thuan.hibernate.utils.HibernateUtils;

public class EmployeeDeparmentProjectMain {

	public static void main(String[] args) {
		insertData();
		updateProject();
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
		Employee emp3 = new Employee("Trong", (byte) 20, 3000, "Dev", "VN");

		// insert Project
		Project p1 = new Project("Project 1", LocalDate.of(2020, 10, 10), LocalDate.of(2020, 12, 12));
		Project p2 = new Project("Project 2", LocalDate.of(2020, 10, 10), LocalDate.of(2020, 12, 12));

		emp1.setDepartment(department);
		emp1.setJob(job);
		emp1.setProjects(List.of(p1));
		emp2.setDepartment(department);
		emp2.setJob(job);
		emp2.setProjects(List.of(p1, p2));
		emp3.setDepartment(department);
		emp3.setJob(job);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);

		t.commit();
		System.out.println("successfully saved");

		session.close();
	}

	private static void updateProject() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// Insert Employee with Department and Job
		Employee emp1 = session.find(Employee.class, 1);
		Employee emp3 = session.find(Employee.class, 3);

		// insert Project
		Project p1 = session.find(Project.class, 1);
		Project p2 = session.find(Project.class, 2);
		Project p3 = new Project("Project 3", LocalDate.of(2020, 10, 10), LocalDate.of(2020, 12, 12));

		emp1.setProjects(List.of(p1, p2));
		emp3.setProjects(List.of(p3));
		session.save(emp1);
		session.save(emp3);

		t.commit();
		System.out.println("successfully saved");

		session.close();
	}

}
