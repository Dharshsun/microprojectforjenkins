package com.microproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.microproject.model.AdminLogin;
import com.microproject.model.UserLogin;

import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;

@Repository
public class AdminLoginRepo {
	
	@Autowired
	private EntityManager entityManager;
	public List<AdminLogin> list;
	
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

	
	public AdminLogin findById(int adminId) {
		AdminLogin adminLogin = entityManager.find(AdminLogin.class, adminId);
	    return adminLogin;
	}

	public AdminLogin findByEmail(String email,String password) {
		Query query= entityManager.createQuery("FROM AdminLogin u WHERE u.email =:email AND u.password =:password");
		query.setParameter("email",email);
		query.setParameter("password",password);
		
	    return (AdminLogin) query.getSingleResult();
	}
	

}
