package com.star.sud.emp.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.star.sud.emp.dto.Employee;
import com.star.sud.emp.model.TEmployee;
import com.star.sud.emp.repo.EmployeeRepository;
import com.star.sud.emp.service.IEmployeeService;
import com.star.sud.exception.ResourceNotFoundException;

@Component
public class EmployeeServiceImpl implements IEmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getEmployees() throws ResourceNotFoundException {

		log.info("getEmployees");

		List<Employee> employees = new ArrayList<>();
		List<TEmployee> findAll = repository.findAll();
		if (findAll.isEmpty())
			throw new ResourceNotFoundException("No records found");

		findAll.stream().forEach(employee -> {
			Employee emp = new Employee();
			BeanUtils.copyProperties(employee, emp);
			employees.add(emp);
		});
		return employees;

	}

	@Override
	public ResponseEntity<Employee> getEmployee(Long empId) throws ResourceNotFoundException, Exception {

		log.info("getEmployee by Id");

		if (null == empId)
			throw new Exception("empId param is null or empty");

		Employee employee = new Employee();

		TEmployee findById = repository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for the employee id:" + empId));
		BeanUtils.copyProperties(findById, employee);

		return ResponseEntity.ok().body(employee);

	}

	@Override
	public ResponseEntity<Object> createEmployee(@Valid Employee employee) throws Exception {

		if (StringUtils.isEmpty(employee))
			throw new Exception("employee request param is null or empty");

		TEmployee entity = new TEmployee();
		BeanUtils.copyProperties(employee, entity);
		TEmployee save = repository.save(entity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getEmpId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@Override
	public void updateEmployee(Long empId, @Valid Employee employee) throws Exception {

		if (null == empId)
			throw new Exception("empId param is null or empty");

		if (StringUtils.isEmpty(employee))
			throw new Exception("employee request param is null or empty");

		TEmployee entity = repository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for the employee id:" + empId));

		BeanUtils.copyProperties(employee, entity);
		entity.setEmpId(empId);
		repository.save(entity);
	}

	@Override
	public void deleteEmployee(@Valid Long empId) throws Exception {

		if (null == empId)
			throw new Exception("empId param is null or empty");

		repository.deleteById(empId);

	}

}
