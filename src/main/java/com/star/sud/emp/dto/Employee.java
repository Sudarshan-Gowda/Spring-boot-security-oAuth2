package com.star.sud.emp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {

	// Properties
	////////////////////
	private Long empId;

	@NotEmpty(message = "Name Should not be null")
	@Length(max = 100, message = "Length should not exceed 100 100 character")
	private String empName;

	@NotNull(message = "Department should not be null")
	@Length(max = 100, message = "Department should not exceed 100 character")
	private String empDept;

	@NotNull(message = "Experience should not be null")
	private Integer empExp;

	@NotNull(message = "Salary should not be null or empty")
	private Double empSalary;

	@Length(max = 35)
	@JsonIgnore
	private String empStatus;

	// Constructors
	///////////////////
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empId
	 * @param empName
	 * @param empDept
	 * @param empExp
	 * @param empSalary
	 * @param empStatus
	 */
	public Employee(Long empId, String empName, String empDept, Integer empExp, Double empSalary, String empStatus) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empExp = empExp;
		this.empSalary = empSalary;
		this.empStatus = empStatus;
	}

	// Properties
	/////////////////

	/**
	 * @return the empSalary
	 */
	public Double getEmpSalary() {
		return empSalary;
	}

	/**
	 * @param empSalary the empSalary to set
	 */
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	/**
	 * @return the empStatus
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * @param empExp the empExp to set
	 */
	public void setEmpExp(Integer empExp) {
		this.empExp = empExp;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empDept
	 */
	public String getEmpDept() {
		return empDept;
	}

	/**
	 * @param empDept the empDept to set
	 */
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	/**
	 * @return the empExp
	 */
	public Integer getEmpExp() {
		return empExp;
	}

}
