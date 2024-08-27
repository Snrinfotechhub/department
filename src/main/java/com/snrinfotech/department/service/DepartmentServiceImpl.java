package com.snrinfotech.department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.snrinfotech.department.dto.DeptDto;
import com.snrinfotech.department.entity.Department;
import com.snrinfotech.department.exception.DepartmentException;
import com.snrinfotech.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Qualifier("department")
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public DeptDto saveDepartment(DeptDto department) {
		
		Department departmnt = new Department();
		departmnt.setDeptName(department.getDepartmentName());
		departmnt.setDeptCode(department.getDepartmentCode());
		
		Department dept1 = departmentRepository.save(departmnt);
		
		return new DeptDto(dept1.getDeptId(),dept1.getDeptCode(),dept1.getDeptName(),null);
	}

	@Override
	public List<DeptDto> getDepartments() {
		
		List<Department> allDepartments = departmentRepository.findAll();
		
		List<DeptDto> deptList = new ArrayList<>();
		
		for(int i = 0;i<allDepartments.size();i++) {
			Department department = allDepartments.get(i);
			DeptDto deptDto = new DeptDto();
			deptDto.setDepartmentId(department.getDeptId());
			deptDto.setDepartmentCode(department.getDeptCode());
			deptDto.setDepartmentName(allDepartments.get(i).getDeptName());
			
			deptList.add(deptDto);
		}
		
		List<DeptDto> deptList2 = new ArrayList<>();
		for(Department department : allDepartments) {
			DeptDto deptDto = new DeptDto();
			deptDto.setDepartmentId(department.getDeptId());
			deptDto.setDepartmentCode(department.getDeptCode());
			deptDto.setDepartmentName(department.getDeptName());
			
			deptList2.add(deptDto);
		}
		 
		List<DeptDto> deptList3 = new ArrayList<>();
		allDepartments.forEach(department->{
			DeptDto deptDto = new DeptDto();
			deptDto.setDepartmentId(department.getDeptId());
			deptDto.setDepartmentCode(department.getDeptCode());
			deptDto.setDepartmentName(department.getDeptName());
			
			deptList3.add(deptDto);
		});
		
//		List<DeptDto> deptList1 = allDepartments.stream().map(department->{
//			DeptDto deptDto = new DeptDto();
//			deptDto.setDepartmentId(department.getDeptId());
//			deptDto.setDepartmentCode(department.getDeptCode());
//			deptDto.setDepartmentName(department.getDeptName());
//			return deptDto;
//		}).collect(Collectors.toList());
//		
		return deptList3;
	}

	@Override
	public DeptDto getDepartmentById(long deptId) {
		Optional<Department> departmentOpt = departmentRepository.findById(deptId);
		DeptDto deptDto = null;
		if(departmentOpt.isPresent()) {
			deptDto = new DeptDto();
			Department department = departmentOpt.get();
			deptDto.setDepartmentId(department.getDeptId());
			deptDto.setDepartmentCode(department.getDeptCode());
			deptDto.setDepartmentName(department.getDeptName());
		}
		
		return deptDto;
	}

	@Override
	public DeptDto updateDepartmentInfoById(long deptId, DeptDto dept) {
		Optional<Department> departmentOpt = departmentRepository.findById(deptId);
		DeptDto deptDto = null;
		Department dept1 = null;
		try {
			if(departmentOpt.isPresent()) {
				deptDto = new DeptDto();
				
				Department department = departmentOpt.get();
				
				department.setDeptCode(dept.getDepartmentCode());
				department.setDeptName(dept.getDepartmentName());
				
				dept1 = departmentRepository.save(department);
				
			}
			
			deptDto.setDepartmentId(dept1.getDeptId());
			
			deptDto.setDepartmentCode(dept1.getDeptCode());
			deptDto.setDepartmentName(dept1.getDeptName());
		}  catch(NullPointerException npe) {
			//System.out.println("NullPointerException : "+npe.getMessage());
			throw new DepartmentException("Department service throwing nulpoinyter exception");
		}  catch(IndexOutOfBoundsException ibe) {
			//System.out.println("IndexOutOfBoundsException : "+ibe.getMessage());
			throw new DepartmentException(ibe.getMessage());
		}  catch(Exception ex) {
			//System.out.println("Exception : "+ex.getMessage() );
			throw new DepartmentException(ex.getMessage());
		} finally {
			System.out.println("the end");
		}
		
		
		return deptDto;
}

	@Override
	public void updateDepartmentInfo(DeptDto dept) {
		Optional<Department> departmentOpt = departmentRepository.findById(dept.getDepartmentId());
		if(departmentOpt.isPresent()) {
			Department department = departmentOpt.get();
			department.setDeptCode(dept.getDepartmentCode());
			department.setDeptName(dept.getDepartmentName());
			departmentRepository.save(department);
		}

	}
}
	
