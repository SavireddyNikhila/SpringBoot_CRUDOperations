package com.springdemo.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.Entity.Department;
import com.springdemo.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchdepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);		
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {
		Department depDB=departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && 
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		return departmentRepository.save(depDB);
	}

	@Override
	public Department fetchdepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public Department updateDepartmentByName(String departmentName, Department department) {
		Department dept=departmentRepository.findByDepartmentName(departmentName);
		if(Objects.nonNull(department.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		
		
		return departmentRepository.save(dept);
	}

//	@Transactional
	@Override
	public void deleteDepartmentByName(String departmentName) {
        departmentRepository.deleteByDepartmentName(departmentName);		
	}
	
	

}
