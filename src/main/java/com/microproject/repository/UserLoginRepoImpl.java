package com.microproject.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.microproject.model.UserLogin;

import jakarta.persistence.EntityManager;

public class UserLoginRepoImpl extends UserLogin{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public UserLogin persist(UserLogin userLogin) {
		entityManager.persist(userLogin);
		return userLogin;
	}

}
