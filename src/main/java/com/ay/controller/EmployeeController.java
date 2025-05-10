package com.ay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ay.entity.EmployeeRecord;
import com.ay.services.EmployeeService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getEmp")
	public ResponseEntity<List<EmployeeRecord>> getAllData(){
		List<EmployeeRecord> list= service.getAllEmployeeRecords();
		
		
		if(list.size()!=0)
			return new ResponseEntity<List<EmployeeRecord>>(list,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<List<EmployeeRecord>>(list,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmp(@RequestBody EmployeeRecord emp){
		String msg=service.insertRecord(emp);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}

}
