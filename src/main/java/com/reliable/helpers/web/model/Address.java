package com.reliable.helpers.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int house_number;
	@Column
	private String street_name;
	@Column
	private String suburb;
	@Column
	private String city;
	@Column
	private String province;
	@Column
	private String country;
	@Column
	private String code;
	@OneToOne(mappedBy = "address")
	private User user;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getHouse_number() {
		return house_number;
	}



	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}



	public String getStreet_name() {
		return street_name;
	}



	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}



	public String getSuburb() {
		return suburb;
	}



	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", house_number=" + house_number
				+ ", street_name=" + street_name + ", suburb=" + suburb
				+ ", city=" + city + ", province=" + province + ", country="
				+ country + ", code=" + code + ", user=" + user + "]";
	}

	
}