package com.reliable.helpers.web.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private JobTitle title;
	
	@Column
	private JobStatus status;
	
	@Column
	private String discription;
	
	@Column(precision = 2)
	private double salary;
	
	
	
	

	@OneToOne(mappedBy = "job")
	private Agreement agreement;
	
	@Lob
	private Set<JobRoles> roles;

	public Agreement getAgreement() {
		return agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobTitle getTitle() {
		return title;
	}

	public void setTitle(JobTitle title) {
		this.title = title;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<JobRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<JobRoles> roles) {
		this.roles = roles;
	}
	
	
	
	
}
