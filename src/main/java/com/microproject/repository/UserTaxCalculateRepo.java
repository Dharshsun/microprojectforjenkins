package com.microproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microproject.model.UserTaxCalculateCredentials;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserTaxCalculateRepo {
	
	@Autowired
	private EntityManager entityManager;
	public List<UserTaxCalculateCredentials> list;

	public UserTaxCalculateCredentials persist(UserTaxCalculateCredentials userTaxCalculateCredentials) {
		entityManager.persist(userTaxCalculateCredentials);
		return userTaxCalculateCredentials;

	}
	
	public UserTaxCalculateCredentials persist1(UserTaxCalculateCredentials userTaxCalculateCredentials, String status) {
		String getallQuery = "UPDATE UserTaxCalculateCredentials u SET u.status =:status WHERE u.taxId =:taxId";
		Query query = entityManager.createQuery(getallQuery);
	    query.setParameter("status", status);
	    query.setParameter("id", userTaxCalculateCredentials.getTaxId());
	    query.executeUpdate();
	    return userTaxCalculateCredentials;

	}

	@SuppressWarnings("unchecked")
	public List<UserTaxCalculateCredentials> getAllUserRequests() {
		String getallQuery = "select a from UserTaxCalculateCredentials a";
		Query query = entityManager.createQuery(getallQuery);
		return query.getResultList();
	}
	

	public String deleteById(int taxId) {
		UserTaxCalculateCredentials userTaxCalculateCredentials = entityManager.find(UserTaxCalculateCredentials.class,taxId);
		if (userTaxCalculateCredentials!= null) {
			entityManager.remove(userTaxCalculateCredentials);
	        return "Deleted Detail with id: " + taxId;
	    } else {
	        return "Detail with id: " + taxId + " not found";
	    }
	}
	
	public void merge(UserTaxCalculateCredentials userTaxCalculateCredentials) {
		UserTaxCalculateCredentials userTaxCalculateCredentials1 = entityManager.find(UserTaxCalculateCredentials.class, userTaxCalculateCredentials.getTaxId());
	    if (userTaxCalculateCredentials1!= null) {
	    	userTaxCalculateCredentials1.setTaxId(userTaxCalculateCredentials1.getTaxId());
	    	userTaxCalculateCredentials1.setAge(userTaxCalculateCredentials1.getAge());
	    	userTaxCalculateCredentials1.setSalary(userTaxCalculateCredentials1.getSalary());
	    	userTaxCalculateCredentials1.setHra(userTaxCalculateCredentials1.getSalary());
	    	userTaxCalculateCredentials1.setAdditionalIncomeResource(userTaxCalculateCredentials1.getAdditionalIncomeResource());
	    	userTaxCalculateCredentials1.setAdditionalIncome(userTaxCalculateCredentials1.getAdditionalIncome());
	    	userTaxCalculateCredentials1.setPropertyTaxAmount(userTaxCalculateCredentials1.getPropertyTaxAmount());
	    	userTaxCalculateCredentials1.setLoanAmount(userTaxCalculateCredentials1.getLoanAmount());
	    	userTaxCalculateCredentials1.setUser(userTaxCalculateCredentials.getUser());
	        entityManager.merge(userTaxCalculateCredentials1);
	    }
	    
	    
}

	public UserTaxCalculateCredentials findByTaxId(UserTaxCalculateCredentials taxId) {
		// TODO Auto-generated method stub
		return taxId;
	}


	public boolean updateStatusApproved(boolean status) {
		return updateStatusApproved(status);
	}
//	public boolean updateStatus(boolean status) {
//		String getallQuery = "UPDATE UserTaxCalculate set status =:status WHERE taxId =:taxId";
//		Boolean query = entityManager.merge(status);
//		return updateStatusApproved(status);
//	}
	public String updateStatus(int taxId,String status) {
	    try {
	        String hql = "UPDATE UserTaxCalculateCredentials set status = :status WHERE taxId = :taxId";
	        Query query = entityManager.createQuery(hql);
	        query.setParameter("status", status);
	        query.setParameter("taxId", taxId);
	        int result = query.executeUpdate();
	        return result > 0 ? "Update successful" : "Update failed";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error occurred: " + e.getMessage();
	    }
	}

	

	public UserTaxCalculateCredentials findByTaxId(int taxId) {
		UserTaxCalculateCredentials userTaxCalculateCredentials = entityManager.find(UserTaxCalculateCredentials.class, taxId);
	    return userTaxCalculateCredentials;
	}
	
//	public UserTaxCalculateCredentials findByTaxUserId(int userId) {
//		UserTaxCalculateCredentials userTaxCalculateCredentials = entityManager.find(UserTaxCalculateCredentials.class, userId);
//	    return userTaxCalculateCredentials;
//	}

	public UserTaxCalculateCredentials findByUserId(int userId) {
		String qu = "SELECT t FROM UserTaxCalculateCredentials t WHERE t.user.userId =:userId";
		Query query = entityManager.createQuery(qu,UserTaxCalculateCredentials.class);
		return (UserTaxCalculateCredentials) query.setParameter("userId", userId).getSingleResult();
		
	}

	public List<UserTaxCalculateCredentials> findTaxInfoByUserId(int userId) {
		String qe = "SELECT u.userName, utc.status FROM User u, UserTaxCredentials utc WHERE u.userId = utc.userId AND u.userId = :userId";
		 Query query = entityManager.createQuery(qe);
		    query.setParameter("userId", userId);
		    List<Object[]> results = query.getResultList();
		    List<UserTaxCalculateCredentials> taxInfoList = new ArrayList<>();
		    for (Object[] result : results) {
		        UserTaxCalculateCredentials taxInfo = new UserTaxCalculateCredentials();
		        taxInfo.setStatus((String) result[0]);
		        taxInfoList.add(taxInfo);
		    }
		    return taxInfoList;
	}
	
	


}
