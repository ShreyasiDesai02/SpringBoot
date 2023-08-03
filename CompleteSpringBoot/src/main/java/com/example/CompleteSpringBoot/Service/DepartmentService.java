package com.example.CompleteSpringBoot.Service;

import java.util.List;

import com.example.CompleteSpringBoot.Error.DepartmentNotFoundException;
import com.example.CompleteSpringBoot.Model.Department;

import jakarta.validation.Valid;

public interface DepartmentService {

	public Department saveDepartment(@Valid Department department);

	List<Department> fetchDepartmentList();

	void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

}
