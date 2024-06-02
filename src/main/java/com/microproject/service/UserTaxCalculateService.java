package com.microproject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microproject.model.UserTaxCalculateCredentials;
import com.microproject.repository.UserLoginRepo;
import com.microproject.repository.UserTaxCalculateRepo;

public interface UserTaxCalculateService {
	
//	@Autowired
//    private UserTaxCalculateRepo userTaxCalculateRepo;
	
//	@Autowired
//	UserLoginRepo userLogin;
//	
//    public UserTaxCalculateCredentials saveOrUpdateAdmin(UserTaxCalculateCredentials userTaxCalculateCredentials) {
//        return userTaxCalculateRepo.persist(userTaxCalculateCredentials);
//    }
//    public int deleteById(int taxId) {
//        userTaxCalculateRepo.deleteById(taxId);
//		return taxId;
//    }
//    public String updateStatus(UserTaxCalculateCredentials userTaxCalculateCredentials, String status) {
//        return userTaxCalculateRepo.updateStatus(0, status);
//    }
//    public UserTaxCalculateCredentials getUserRequestById(int taxId) {
//        return userTaxCalculateRepo.findByTaxId(taxId);
//    }
//    
//    public UserTaxCalculateCredentials getUserRequestById1(int userId) {
//    	return userTaxCalculateRepo.findByUserId(userId);
//		}
    boolean insertUserData(int userId, String userName, int age, int salary, int hra,
            String additionalIncomeResource, int additionalIncome,
            int propertyTaxAmount, int loanAmount, int calculatedTax,
            MultipartFile file) throws IOException;
    
    List<UserTaxCalculateCredentials> findTaxInfoByUserId(int userId);
    
}


