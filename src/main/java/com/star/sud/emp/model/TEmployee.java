package com.star.sud.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_EMPLOYEE", uniqueConstraints = { @UniqueConstraint(columnNames = "EMP_ID") })
public class TEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID", unique = true)
	private Long empId;

	@Column(name = "EMP_NAME", length = 100, nullable = false)
	private String empName;

	@Column(name = "EMP_DEPT", length = 100, nullable = false)
	private String empDept;

	@Column(name = "EMP_EXP", length = 5, nullable = false)
	private Integer empExp;

	@Column(name = "EMP_SALARY", length = 10, nullable = false)
	private Double empSalary;

	@Column(name = "EMP_STATUS", length = 35)
	private String empStatus;

	/**
	 * 
	 */
	public TEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TEmployee(Long empId, String empName, String empDept, Integer empExp, Double empSalary, String empStatus) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empExp = empExp;
		this.empSalary = empSalary;
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "TEmployee [empId=" + empId + ", empName=" + empName + ", empDept=" + empDept + ", empExp=" + empExp
				+ ", empSalary=" + empSalary + "]";
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

	/**
	 * @param empExp the empExp to set
	 */
	public void setEmpExp(Integer empExp) {
		this.empExp = empExp;
	}

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

}
