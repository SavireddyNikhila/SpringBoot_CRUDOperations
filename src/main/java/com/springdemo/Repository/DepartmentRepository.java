package com.springdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
 
	public Department findByDepartmentName(String departmentName);
	public Department findByDepartmentNameIgnoreCase(String departmentName);

	@Transactional
	@Modifying
	public void deleteByDepartmentName(String departmentName);
	//public void deleteByDepartmentNameIgnoreCase(String departmentName);

}
