package com.microproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microproject.model.TaxRegimes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TaxRegimeRepo {
	
	@Autowired
	private EntityManager entityManager;
	public List<TaxRegimes> list;
	
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
