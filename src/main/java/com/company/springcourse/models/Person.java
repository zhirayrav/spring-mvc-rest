package com.company.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class Person {
	
	private int id;
	@NotEmpty(message="Name shoud not be empty")
	@Size(min = 2,max = 30, message="Name shoud be between 2 and 30 characters")
	private String name;
	@Min(value=0,message="Age shoud be greater than 0")
	@Max(value=150,message="Please enter your real age)!")
	private int age;
	@Email(message = "Please enter valid email!")
	@NotEmpty(message = "Email shoud not be empty")
	private String email;
	@Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",message = "Your address shoud be in this format: Country, City, Postal Code(6 digits)")
	private String address;
	
	public Person() {}
	public Person(int id, String name, int age, String email,String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
