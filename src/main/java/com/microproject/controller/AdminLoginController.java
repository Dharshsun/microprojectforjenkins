package com.microproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microproject.model.AdminLogin;
import com.microproject.model.UserLogin;
import com.microproject.repository.AdminLoginRepo;

import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin("http://localhost:3000/")
public class AdminLoginController {
	
	@Autowired
	AdminLoginRepo adminLoginRepo;
	
	@PostMapping("/InsertAdmin")
	public String getInsert(@RequestBody AdminLogin adminLogin) {

		String msg = "";
		try {
			adminLoginRepo.persist(adminLogin);
			msg = "Admin inserted";
		} catch (Exception e) {
			msg = "Admin not inserted";
		}
		return msg;
		
	}
	@GetMapping("/Admingetall")
	public List<AdminLogin> getAllAdmin() {
		List<AdminLogin> list = adminLoginRepo.getAllAdmin();
		return list;
	}
	@GetMapping("/getAdmin/{adminId}")
	public AdminLogin doGetAdmin(@PathVariable int adminId) {
		System.out.println(adminId + " : admin id");
		return (AdminLogin) ((Object) adminLoginRepo.findById(adminId));
	}
	
	@PostMapping("/getAdminByEmail")
	public AdminLogin doGetUser(@RequestBody AdminLogin loginadmin) {
		loginadmin.getEmail();
		loginadmin.getPassword();
		return adminLoginRepo.findByEmail(loginadmin.getEmail(),loginadmin.getPassword());

	}
}



