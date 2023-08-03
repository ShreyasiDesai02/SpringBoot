package com.practise.employeeservice.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practise.employeeservice.Model.Employee;

@Repository
public class EmployeeRepo {
	
	
	 private List<Employee> employees
     = new ArrayList<>();
	
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return employees.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
	}

	public Employee add(Employee employee) {
		// TODO Auto-generated method stub
		 employees.add(employee);
		 return employee;
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employees;
	}

	public List<Employee> findByDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		return employees.stream()
				.filter(a -> a.departmentId().equals(departmentId))
				.toList();
	}

}
