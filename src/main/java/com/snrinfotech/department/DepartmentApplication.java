package com.snrinfotech.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentApplication{

	public static void main(String[] args) {
		System.out.println("DepartmentApplication method stated");
		SpringApplication.run(DepartmentApplication.class, args);
	}

}
