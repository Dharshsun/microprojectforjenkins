package com.microproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microproject.model.UserLogin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class UserLoginRepo {

	@Autowired
	private EntityManager entityManager;
	public List<UserLogin> list;

	public UserLogin persist(UserLogin userLogin) {
		entityManager.persist(userLogin);
		return userLogin;
	}

	@SuppressWarnings("unchecked")
	public List<UserLogin> getAllUser() {
		String getallQuery = "select a from UserLogin a";
		Query query = entityManager.createQuery(getallQuery);
		return query.getResultList();
	}

	
	public UserLogin findById(int userId) {
		UserLogin userLogin = entityManager.find(UserLogin.class, userId);
	    return userLogin;
	}

	public UserLogin findByEmail(String userEmail,String password) {
		Query query= entityManager.createQuery("FROM UserLogin u WHERE u.userEmail =:userEmail AND u.password =:password");
		query.setParameter("userEmail",userEmail);
		query.setParameter("password",password);
		
	    return (UserLogin) query.getSingleResult();
	}
	
	

	
}
