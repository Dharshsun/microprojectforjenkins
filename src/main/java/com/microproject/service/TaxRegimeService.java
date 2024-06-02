package com.microproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.microproject.model.TaxRegimes;
import com.microproject.repository.TaxRegimeRepo;

public class TaxRegimeService {
	
	@Autowired
    private TaxRegimeRepo taxRegimeRepo;
	
	public TaxRegimes saveOrUpdateAdmin(TaxRegimes taxRegimes) {
        return taxRegimeRepo.persist(taxRegimes);
    }

}
