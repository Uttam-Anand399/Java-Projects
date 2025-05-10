
package com.ay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.entity.EmployeeRecord;
import com.ay.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	
	public List<EmployeeRecord> getAllEmployeeRecords(){
		List<EmployeeRecord> list =repo.findAll();
		
		return list;
	}
	
	public String insertRecord(EmployeeRecord emp) {
		EmployeeRecord newEmp=repo.save(emp);
		if(newEmp.getEmpId() != null) 
			return "Record saved Sucessfully";
		else
			return "Failed to insert";
	}
	
	

}
