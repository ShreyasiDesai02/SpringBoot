package com.practise.departmentservice.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.departmentservice.Client.EmployeeClient;
import com.practise.departmentservice.Model.Department;
import com.practise.departmentservice.Repository.DepartmentRepo;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static Logger LOGGER
				= LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepo departmentRepo;
	private EmployeeClient employeeClient;
	
	@PostMapping
	public Department add(@RequestBody Department department) {
		LOGGER.info("Inside save Department of fetchDepartment DepartmentController");
		return departmentRepo.addDepartment(department);
	}
	
	@GetMapping
	public List<Department> findAll(){
		LOGGER.info("Department find");
		return departmentRepo.findAll();
	} 
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		LOGGER.info("Department find: id={}", id);
		return departmentRepo.findById(id);
	}
	
	@GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments
                = departmentRepo.findAll();
        departments.forEach(department ->
                department.setEmployee(
                        employeeClient.findByDepartment(department.getId())));
        return  departments;
    }

}
