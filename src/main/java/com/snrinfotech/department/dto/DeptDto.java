package com.snrinfotech.department.dto;

import java.util.List;

public class DeptDto{

	
	private long departmentId;
	private String departmentName;
	
	private String departmentCode;
	
	private List<EmployeeDto> empDto;
	
	public DeptDto() {}

	public DeptDto(long departmentId, String departmentName, String departmentCode,
			List<EmployeeDto> empDto1) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.empDto = empDto1;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public List<EmployeeDto> getEmpDto() {
		return empDto;
	}

	public void setEmpDto(List<EmployeeDto> empDto) {
		this.empDto = empDto;
	}

	
	
	
	
}
