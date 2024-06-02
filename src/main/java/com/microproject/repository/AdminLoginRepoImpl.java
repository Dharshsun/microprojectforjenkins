package com.microproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microproject.model.AdminLogin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AdminLoginRepoImpl extends AdminLoginRepo{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public AdminLogin persist(AdminLogin adminLogin) {
		entityManager.persist(adminLogin);
		return adminLogin;
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminLogin> getAllAdmin() {
		String getallQuery = "select a from AdminLogin a";
		Query query = entityManager.createQuery(getallQuery);
		return query.getResultList();

	}

}
