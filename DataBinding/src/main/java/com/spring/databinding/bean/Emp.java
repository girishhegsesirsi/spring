package com.spring.databinding.bean;

import java.util.List;

public class Emp {
	private int id;
	private String name;
	private int salary;
	private String destination;
	private List<String> course;
	private Address empAddres;
	
	public Emp(int id, String name, int salary, String destination, List<String> course, Address empAddres) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.destination = destination;
		this.course = course;
		this.empAddres = empAddres;
	}
	public Emp(int id, String name, int salary, String destination,  Address empAddres) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.destination = destination;
		this.empAddres = empAddres;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<String> getCourse() {
		return course;
	}
	public void setCourse(List<String> course) {
		this.course = course;
	}
	public Address getEmpAddres() {
		return empAddres;
	}
	public void setEmpAddres(Address empAddres) {
		this.empAddres = empAddres;
	}

}
