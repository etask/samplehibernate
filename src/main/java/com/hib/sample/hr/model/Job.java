package com.hib.sample.hr.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="JOBS")
public class Job {
	
	@Id
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(nullable=false,name="JOB_TITLE")
	private String jobTitle;

	@Column(name="MIN_SALARY")
	private BigDecimal minSalary;
	
	@Column(name="MAX_SALARY")
	private BigDecimal maxSalary;
	
	@OneToMany(mappedBy="job")
	private Set<Employee> employees = new HashSet<Employee>();

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public BigDecimal getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
}
