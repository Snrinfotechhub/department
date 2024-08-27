package com.snrinfotech.department.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.snrinfotech.department.dto.DeptDto;
import com.snrinfotech.department.service.DepartmentService;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@InjectMocks
	DepartmentController departmentController;
	
	@Mock
	DepartmentService departmentService;
	
	@BeforeEach
	void setup() {
		
		System.out.println("before each");
	}
	
//	public DeptDto saveDepartment(@RequestBody DeptDto department) {
//		return departmentService.saveDepartment(department);
//	}
	
	@Test
	void saveDepartmentTest() {
		DeptDto abcd = new DeptDto();
		abcd.setDepartmentCode("100");
		when(departmentService.saveDepartment(any(DeptDto.class))).thenReturn(abcd);
		DeptDto deptDto = departmentController.saveDepartment(new DeptDto());
		assertEquals("100", deptDto.getDepartmentCode());
	}

//public List<DeptDto> getDepartments(){
//		
//		return departmentService.getDepartments();
//		
//	}
	@Test
	void getDepartmentsTest() {
		DeptDto dept = new DeptDto();
		List<DeptDto> departmentList = new ArrayList<>();
		departmentList.add(dept);
		
		when(departmentService.getDepartments()).thenReturn(departmentList);
		List<DeptDto> deptList = departmentController.getDepartments();
		assertNotEquals(2, deptList.size());
		
		
	}
}
