package com.practise.departmentservice.Model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Long id;
	private String name;
	private List<Employee> employee = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department() {
		super();
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	

}
