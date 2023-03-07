package com.springdemo.Service;

import java.util.List;

import com.springdemo.Entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchdepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartmentById(Long departmentId, Department department);

	public Department fetchdepartmentByName(String departmentName);

	public Department updateDepartmentByName(String departmentName, Department department);

	public void deleteDepartmentByName(String departmentName);

     
	
}
