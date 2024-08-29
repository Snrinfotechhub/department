package com.snrinfotech.department.dto;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
public class EmployeeDto {

	private long employeeId;
	private long departmentId;
	private String employeeName;
	public EmployeeDto() {
		
	}
	public EmployeeDto(long employeeId, long departmentId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.employeeName = employeeName;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	
}
