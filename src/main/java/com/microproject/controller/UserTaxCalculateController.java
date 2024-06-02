package com.microproject.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microproject.model.UserLogin;
import com.microproject.model.UserTaxCalculateCredentials;
import com.microproject.repository.UserLoginRepo;
import com.microproject.repository.UserTaxCalculateRepo;
import com.microproject.service.UserTaxCalculateService;
import com.microproject.service.UserTaxCalculateServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserTaxCalculateController {

	@Autowired
	UserTaxCalculateRepo userTaxCalculateRepo;

	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserTaxCalculateService userTaxCalculateService;
	
	@PostMapping(path = "/insertUserData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean insertUserData(
	        @RequestParam("userId") int userId,
	        @RequestParam("userName") String userName,
	        @RequestParam("age") int age,
	        @RequestParam("salary") int salary,
	        @RequestParam("hra") int hra,
	        @RequestParam("additionalIncomeResource") String additionalIncomeResource,
	        @RequestParam("additionalIncome") int additionalIncome,
	        @RequestParam("propertyTaxAmount") int propertyTaxAmount,
	        @RequestParam("loanAmount") int loanAmount,
	        @RequestParam("calculatedTax") int calculatedTax,
	        @RequestParam("file") MultipartFile file
	) throws IOException {
	    return userTaxCalculateService.insertUserData(userId, userName, age, salary, hra, additionalIncomeResource,
	            additionalIncome, propertyTaxAmount, loanAmount, calculatedTax, file);
	}
	
	
	
	@PutMapping("/update/{taxId}/{status}")
	public String updateStatus1(@PathVariable int taxId, @PathVariable String status) {
		System.out.println("IN Controller"+taxId);
		return userTaxCalculateRepo.updateStatus(taxId,status);
	}


	@PostMapping(path = "/UpdateUserStatus")
	public boolean updateStatus(@RequestParam("taxId")  int taxId, @RequestParam("status") String status) {
	  System.out.println(taxId);
	  System.out.println(status);
		
	    return true;
	}
	@GetMapping("/UserRequestsgetall")
	public List<UserTaxCalculateCredentials> getAllAdmin() {
		List<UserTaxCalculateCredentials> list = userTaxCalculateRepo.getAllUserRequests();
		return list;
	}
	@GetMapping("/UserRequestsgetbyId/{taxId}")
	public UserTaxCalculateCredentials getUserRequestById(@PathVariable int taxId) {
		return (UserTaxCalculateCredentials) ((Object) userTaxCalculateRepo.findByTaxId(taxId));
	}
	
	
	@GetMapping("/UserRequestsgetbyUserId/{userId}")
	public UserTaxCalculateCredentials getUserRequestByUserId(@PathVariable int userId) {
				return (UserTaxCalculateCredentials) ((Object) userTaxCalculateRepo.findByUserId(userId));
	}
	
	
	@DeleteMapping("/DeleteUserRequestById/{taxId}")
	public String getDelete(@PathVariable int taxId) {

		String msg = "";
		try {
			userTaxCalculateRepo.deleteById(taxId);
			msg = "User Data declined";
		} catch (Exception e) {
			msg = "User  not Data declined";
		}
		return msg;
	}
	
	
	

}
