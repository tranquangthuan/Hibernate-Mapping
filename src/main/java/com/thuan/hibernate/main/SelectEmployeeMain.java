package com.thuan.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.entity.Job;
import com.thuan.hibernate.utils.HibernateUtils;

public class SelectEmployeeMain {

	public static void main(String[] args) {
		// selectEmpoyee(1);
		selectDeparment(1);
	}

	public static void selectEmpoyee(int employeeId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		System.out.println("Find Employee Information");
		Employee em = session.find(Employee.class, employeeId);
		System.out.println(em);
		System.out.println("Employee =============: Get Department name");
		Department ed = em.getDepartment();
		System.out.println(ed.getName());
		
		System.out.println("Employee =============: Get Job name");
		Job job = em.getJob();
		System.out.println(job);
		
		System.out.println("Employee =============: Get List Employee name");
		List<Employee> employees = job.getEmployees();
		System.out.println(employees.size());

		session.close();
		factory.close();
	}

	public static void selectDeparment(int departmentId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		System.out.println("Find Department Information");
		Department dp = session.find(Department.class, departmentId);
		System.out.println(dp);
		System.out.println("Department =============: Get Department Employee");
		List<Employee> employees = dp.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		session.close();
		factory.close();
	}
}
