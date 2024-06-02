package com.microproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microproject.model.TaxRegimes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class TaxRegimeRepoImpl extends TaxRegimeRepo{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public TaxRegimes persist(TaxRegimes taxRegimes) {
		entityManager.persist(taxRegimes);
		return taxRegimes;
	}
	@SuppressWarnings("unchecked")
	public List<TaxRegimes> getAllRegimes() {
		String getallQuery = "select a from TaxRegimes a";
		Query query = entityManager.createQuery(getallQuery);
		return query.getResultList();
	}

}
