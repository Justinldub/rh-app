package com.reliable.helpers.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "user")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String first_name;
	@Column
	private String surname;
	@Column
	private String id_number;
	@Column
	private String email;
	@Column
	private String contact_numbers;
	@Column
	private Nationality nationality;
	@Column
	private String race;
	@Column
	private Role role;
	
	@Lob
	private ArrayList<Languages> languages;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="address_id")
	private Address address;
	@JsonIgnore
	@OneToMany()
	@JoinTable
	private List<Agreement> agreements;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_numbers() {
		return contact_numbers;
	}
	public void setContact_numbers(String contact_numbers) {
		this.contact_numbers = contact_numbers;
	}
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public ArrayList<Languages> getLanguages() {
		return languages;
	}
	public void setLanguages(ArrayList<Languages> languages) {
		this.languages = languages;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Agreement> getAgreements() {
		return agreements;
	}
	public void setAgreements(List<Agreement> agreements) {
		this.agreements = agreements;
	}
	


	

	
	
}
