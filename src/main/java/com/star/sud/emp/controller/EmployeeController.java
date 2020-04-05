package com.star.sud.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.star.sud.emp.dto.Employee;
import com.star.sud.emp.service.IEmployeeService;
import com.star.sud.exception.ResourceNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() throws ResourceNotFoundException {
		return service.getEmployees();
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId)
			throws ResourceNotFoundException, Exception {
		return service.getEmployee(empId);
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) throws Exception {
		return service.createEmployee(employee);
	}

	@PutMapping(value = "/employees/{id}")
	public void updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("id") Long empId) throws Exception {
		service.updateEmployee(empId, employee);
	}

	@DeleteMapping(value = "/employees/{id}")
	public void deleteEmployee(@PathVariable(name = "id") Long empId) throws Exception {
		service.deleteEmployee(empId);
	}

}
