package com.reliable.helpers.web.model;

public class Languages {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Languages(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
