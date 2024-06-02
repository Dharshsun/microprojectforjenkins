package com.microproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
public class UserTaxCalculateRepoImpl extends UserTaxCalculateRepo{
	@Autowired
	private EntityManager entityManager;
	
	public UserTaxCalculateRepo persist(UserTaxCalculateRepo userTaxCalculateRepo) {
		entityManager.persist(userTaxCalculateRepo);
		return userTaxCalculateRepo;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserTaxCalculateRepo> getAllUserTaxCalculate() {
		String getallQuery = "select a from UserTaxCalculateRepo a";
		Query query = entityManager.createQuery(getallQuery);
		return query.getResultList();

	}

}
