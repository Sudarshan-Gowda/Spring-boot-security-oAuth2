package com.star.sud.emp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.star.sud.emp.dto.Employee;
import com.star.sud.exception.ResourceNotFoundException;

public interface IEmployeeService {

	List<Employee> getEmployees() throws ResourceNotFoundException;

	ResponseEntity<Employee> getEmployee(Long empId) throws ResourceNotFoundException, Exception;

	ResponseEntity<Object> createEmployee(@Valid Employee employee) throws Exception;

	void updateEmployee(Long empId, @Valid Employee employee) throws Exception;

	void deleteEmployee(@Valid Long empId) throws Exception;

}
