package com.ay.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.dto.LoginRequest;
import com.ay.entity.User;
import com.ay.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	
	public List<User> getAllUsers(){
	List<User> list= repo.findAll();
	
	return list;
	}
	
	public String insertData(User us) {
		User newUS=repo.save(us);
		if(newUS.getId() != null) 
			return "Record saved Sucessfully";
		else
			return "Failed to insert";
	}
	public String loginUser(LoginRequest request) {
        Optional<User> userOptional = repo.findByEmail(request.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(request.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }
	

}
