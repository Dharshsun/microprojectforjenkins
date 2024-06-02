package com.microproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.microproject.model.UserLogin;
import com.microproject.repository.UserLoginRepo;

public class UserLoginService {
	
	 @Autowired
	    private UserLoginRepo userLoginRepository;
	 
	 public UserLogin saveOrUpdateUser(UserLogin userLogin) {
	        return userLoginRepository.persist(userLogin);
	    }
	 public UserLogin getUserLoginById(int userId) {
	        return userLoginRepository.findById(userId);
	    }
	 public UserLogin getUserLoginByEmail(String userEmail,String password) {
	        return userLoginRepository.findByEmail(userEmail, password);
	    }

}
