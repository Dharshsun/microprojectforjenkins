package com.microproject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microproject.controller.AdminLoginController;
import com.microproject.controller.TaxRegimeController;
import com.microproject.controller.UserLoginController;
import com.microproject.controller.UserTaxCalculateController;
import com.microproject.model.AdminLogin;
import com.microproject.model.TaxRegimes;
import com.microproject.model.UserLogin;
import com.microproject.model.UserTaxCalculateCredentials;
@SpringBootTest
class MicroProjectApplicationTests {
	
	@Autowired
	UserLoginController userlogincontroller;
	@Autowired
	AdminLoginController controller;
	@Autowired
	TaxRegimeController controllertaxregime;
	@Autowired
	UserTaxCalculateController userTaxCalculateController;
	
	@Test
	void testAdminLogin() throws Exception {
		AdminLogin adminlogin = new AdminLogin();
		adminlogin.setEmail("admin@gmail.com");
		adminlogin.setPassword("Admin@123");
	    String result = controller.getInsert(adminlogin);
		assertEquals("Admin inserted", result);

	}
	@Test
	void testRegimeInsert() throws Exception{
		TaxRegimes taxregimes = new TaxRegimes();
		taxregimes.setTaxRegimeCategory("new Regime");
		taxregimes.setAgecategory(40);
		taxregimes.setIncomeAmount(2000000);
		taxregimes.setTaxPercentage(30);
		AdminLogin adminlogin = new AdminLogin();
		adminlogin.setAdminId(1);
		String result = controllertaxregime.doRegisterInsert(taxregimes);
		assertEquals("Insertion Success", result);
	}
	@Test
	void testUserLogin() throws Exception {
		UserLogin adminlogin = new UserLogin();
		adminlogin.setUserEmail("dharshsun@gmail.com");
		adminlogin.setPassword("Dharshsun@123");
	    String result = userlogincontroller.doRegisterInsert(adminlogin);
		assertEquals("register Success", result);
}
	
	
	
	
	
	

}
