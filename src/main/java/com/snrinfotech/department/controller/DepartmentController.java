package com.snrinfotech.department.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snrinfotech.department.dto.DeptDto;
import com.snrinfotech.department.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	@Qualifier("department")
	DepartmentService departmentService;
	
	@PostMapping("/save")
	public DeptDto saveDepartment(@RequestBody DeptDto department) {
		DeptDto deptDto = departmentService.saveDepartment(department);
		return deptDto;
	}
	
	@GetMapping("getDepts")
	public List<DeptDto> getDepartments(){
		
		return departmentService.getDepartments();
		
	}
	
	@GetMapping("getDeptById")
	public DeptDto getDepartmentById(@RequestParam(value="deptId",required = false) long deptId,@RequestParam("deptName") String deptName){
		return departmentService.getDepartmentById(deptId);
		
	}
	
	@GetMapping("getDept/deptId/{id}/deptName/{deptName}")
	public DeptDto getDepartmentByIdPath(@PathVariable("id") long deptId,@PathVariable("deptName") String deptName){
		
		return departmentService.getDepartmentById(deptId);
		
	}
	
	@PutMapping("updateDept/{id}")
	public DeptDto updateDepartmentInfoById(@PathVariable("id") long deptId,@RequestBody DeptDto department) {
		
		return departmentService.updateDepartmentInfoById(deptId,department);
		
	}
	
	@PutMapping("updateDept")
	public void updateDepartmentInfo(@RequestBody DeptDto department) {
		
		departmentService.updateDepartmentInfo(department);
		
	}
	
	
}
