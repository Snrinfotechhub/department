package com.snrinfotech.department.service;

import java.util.List;

import com.snrinfotech.department.dto.DeptDto;

public interface DepartmentService {

	public DeptDto saveDepartment(DeptDto department);

	public List<DeptDto> getDepartments();

	public DeptDto getDepartmentById(long deptId);

	public DeptDto updateDepartmentInfoById(long deptId, DeptDto department);

	public void updateDepartmentInfo(DeptDto department);

}
