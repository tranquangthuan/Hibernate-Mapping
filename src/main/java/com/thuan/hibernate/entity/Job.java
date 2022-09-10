package com.thuan.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_id")
	private int jobId;

	@Column(name = "job_title", length = 255, nullable = false)
	private String jobTitle;

	@Column(name = "min_salary", precision = 11, scale = 2)
	private double minSalary;

	@Column(name = "max_salary", precision = 11, scale = 2)
	private double maxSalary;

	@OneToOne(mappedBy = "job", cascade = CascadeType.ALL)
	private JobDetails jobDetail;

	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private List<Employee> employees;

	public Job() {
		super();
	}

	public Job(String jobTitle, double minSalary, double maxSalary) {
		super();
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public JobDetails getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetails jobDetail) {
		this.jobDetail = jobDetail;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + ", jobDetail=" + jobDetail + ", employees=" + employees + "]";
	}

}
