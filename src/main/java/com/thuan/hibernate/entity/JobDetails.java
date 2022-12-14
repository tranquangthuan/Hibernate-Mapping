package com.thuan.hibernate.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class JobDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_detail_id")
	private int jobDetailId;

	@Column(name = "job_description", length = 255)
	private String jobDescription;

	@Column(name = "active_date")
	private LocalDate activeDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id_from_detail", referencedColumnName = "job_id")
	private Job job;

	public JobDetails() {
		super();
	}

	public JobDetails(String jobDescription, LocalDate activeDate, Job job) {
		super();
		this.jobDescription = jobDescription;
		this.activeDate = activeDate;
		this.job = job;
	}

	public int getJobDetailId() {
		return jobDetailId;
	}

	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public LocalDate getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(LocalDate activeDate) {
		this.activeDate = activeDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "JobDetails [jobDetailId=" + jobDetailId + ", jobDescription=" + jobDescription + ", activeDate="
				+ activeDate + "]";
	}

}
