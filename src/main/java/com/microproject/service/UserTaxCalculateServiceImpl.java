package com.microproject.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microproject.model.UserLogin;
import com.microproject.model.UserTaxCalculateCredentials;
import com.microproject.repository.UserTaxCalculateRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class UserTaxCalculateServiceImpl implements UserTaxCalculateService{
	
	@Autowired
    private UserTaxCalculateRepo userTaxCalculateRepo;
	@Autowired
	 private EntityManager entityManager;

    public UserTaxCalculateCredentials saveOrUpdateAdmin(UserTaxCalculateCredentials userTaxCalculateCredentials) {
        return userTaxCalculateRepo.persist(userTaxCalculateCredentials);
    }
    public int deleteById(int taxId) {
        userTaxCalculateRepo.deleteById(taxId);
		return taxId;
    }

   
    @Override
    public boolean insertUserData(int userId, String userName, int age, int salary, int hra,
                                   String additionalIncomeResource, int additionalIncome,
                                   int propertyTaxAmount, int loanAmount, int calculatedTax,
                                   MultipartFile file) throws IOException {
 
        UserTaxCalculateCredentials userTaxCalculateCredentials = new UserTaxCalculateCredentials();
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(userId);
        userLogin.setUserName(userName);
        userTaxCalculateCredentials.setUser(userLogin);
        userTaxCalculateCredentials.setAge(age);
        userTaxCalculateCredentials.setSalary(salary);
        userTaxCalculateCredentials.setHra(hra);
        userTaxCalculateCredentials.setAdditionalIncomeResource(additionalIncomeResource);
        userTaxCalculateCredentials.setAdditionalIncome(additionalIncome);
        userTaxCalculateCredentials.setPropertyTaxAmount(propertyTaxAmount);
        userTaxCalculateCredentials.setLoanAmount(loanAmount);
        userTaxCalculateCredentials.setCalculatedTax(calculatedTax);
        userTaxCalculateCredentials.setData(Base64.getEncoder().encode(file.getBytes()));
        userTaxCalculateCredentials.setDocName(file.getOriginalFilename());
        userTaxCalculateCredentials.setDocType(file.getContentType());
 
        boolean success = false;
        try {
            userTaxCalculateRepo.persist(userTaxCalculateCredentials);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }
    
    @Override
    public List<UserTaxCalculateCredentials> findTaxInfoByUserId(int userId) {
        String qe = "SELECT u.userName, utc.status FROM User u, UserTaxCredentials utc WHERE u.userId = utc.userId AND u.userId = :userId";
        Query query = entityManager.createQuery(qe);
        query.setParameter("userId", userId);
        List<Object[]> results = query.getResultList();

        List<UserTaxCalculateCredentials> taxInfoList = new ArrayList<>();
        for (Object[] result : results) {
            UserTaxCalculateCredentials taxInfo = new UserTaxCalculateCredentials();
//            taxInfo.setUserName((String) result[0]); // Assuming the first element is userName
            taxInfo.setStatus((String) result[1]); // Assuming the second element is status
            taxInfoList.add(taxInfo);
        }
        return taxInfoList;
    }
}
