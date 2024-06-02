package com.microproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microproject.model.UserLogin;
import com.microproject.repository.UserLoginRepo;

@Service
public class UserLoginServiceImpl extends UserLoginService{

	 @Autowired
	    private UserLoginRepo userLoginRepository;

	    public UserLogin saveOrUpdateAdmin(UserLogin userLogin) {
	        return userLoginRepository.persist(userLogin);
	    }
}
