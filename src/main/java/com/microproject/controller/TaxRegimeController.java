package com.microproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microproject.model.TaxRegimes;
import com.microproject.repository.TaxRegimeRepo;

@RestController
@CrossOrigin("http://localhost:3000/")
public class TaxRegimeController {
	
	@Autowired
	private TaxRegimeRepo taxRegimeRepo;
	
	@PostMapping("/TaxRegimes")
	public String doRegisterInsert(@RequestBody TaxRegimes taxRegimes) {
	    String msg = "";
	    try {
	    	taxRegimeRepo.persist(taxRegimes);
	        msg = "Insertion Success";
	    } catch (Exception e) {
	        msg = "Insertion failure";
	        throw e; 
	    }
	    return msg;
	}
	@GetMapping("/AllRegimes")
	public List<TaxRegimes> getAllUser() {
		List<TaxRegimes> list = taxRegimeRepo.getAllRegimes();
		return list;
	}

}
