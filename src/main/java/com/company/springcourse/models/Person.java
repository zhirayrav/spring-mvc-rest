package com.company.springcourse.models;

public class Person {
	
	private int id;
	private String name;
	
	public Person() {}
	
	public Person(int id,String name) {
		this.name = name;
		this.id = id;
	}
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
}
