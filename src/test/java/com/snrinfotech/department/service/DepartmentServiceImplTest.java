package com.snrinfotech.department.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.snrinfotech.department.dto.DeptDto;
import com.snrinfotech.department.entity.Department;
import com.snrinfotech.department.exception.DepartmentException;
import com.snrinfotech.department.repository.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

	@InjectMocks
	DepartmentServiceImpl departmentServiceImpl;
	
	@Mock
	DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setup() {
		System.out.println("Before Each");
	}
	
	@Test
	void updateDepartmentInfoByIdTest() {
	
		DeptDto deptDto1 = new DeptDto();
		deptDto1.setDepartmentCode("ABC");
		deptDto1.setDepartmentName("XYZ");
		Department department = new Department();
		department.setDeptId(104);
		when(departmentRepository.findById(any(Long.class))).thenReturn(Optional.of(department));
		when(departmentRepository.save(any(Department.class))).thenReturn(department);
		DeptDto deptDto = departmentServiceImpl.updateDepartmentInfoById(104, deptDto1);
		assertNotNull(deptDto);
	}
	
	@Test
	void updateDepartmentInfoByIdTestException() {
	
		DeptDto deptDto1 = new DeptDto();
		deptDto1.setDepartmentCode("ABC");
		deptDto1.setDepartmentName("XYZ");
		Department department = null;

		
		when(departmentRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(DepartmentException.class, () -> {
        	departmentServiceImpl.updateDepartmentInfoById(121, deptDto1);
        });
	}
}
