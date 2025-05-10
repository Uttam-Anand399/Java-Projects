package com.ay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ay.dto.LoginRequest;
import com.ay.entity.User;
import com.ay.services.UserService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registeruser(@RequestBody User us){
		String msg=service.insertData(us);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginuser(@RequestBody LoginRequest request){
		String result=service.loginUser(request);
		
		
		if(result.equals("Login Successfull")) {
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}
		else if(result.equals("Invalid Password")) {
			return new ResponseEntity<String>(result,HttpStatus.UNAUTHORIZED);
		}
		else {
			return new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
		}
	}
	

}
