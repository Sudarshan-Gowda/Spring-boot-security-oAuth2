package com.star.sud.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.emp.model.TEmployee;

public interface EmployeeRepository extends JpaRepository<TEmployee, Long> {

}
