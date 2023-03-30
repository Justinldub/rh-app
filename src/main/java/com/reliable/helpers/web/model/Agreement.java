package com.reliable.helpers.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agreement")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Agreement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Contract contract;
	
	@Column
	private JobTitle title;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private User employee;
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private User employer;
	@Column
	private AgreementStatus status;
	
	
	

	@OneToOne
	@JoinColumn(name = "job_id")
	private Job job;

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public User getEmployer() {
		return employer;
	}

	public void setEmployer(User employer) {
		this.employer = employer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public JobTitle getTitle() {
		return title;
	}

	public void setTitle(JobTitle title) {
		this.title = title;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public AgreementStatus getStatus() {
		return status;
	}

	public void setStatus(AgreementStatus status) {
		this.status = status;
	}

	
	
}
