package com.microproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microproject.model.UserLogin;
import com.microproject.repository.UserLoginRepo;

import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin("http://localhost:3000")
public class UserLoginController {

	@Autowired
	private UserLoginRepo userLoginRepo;

	@PostMapping("/UserRegister")
	public String doRegisterInsert(@RequestBody UserLogin loginforregister) {
		String msg = "";
		try {
			userLoginRepo.persist(loginforregister);
			msg = "register Success";
		} catch (Exception e) {
			msg = "register failure";
			throw e;
		}
		return msg;
	}

	@GetMapping("/Usergetall")
	public List<UserLogin> getAllUser() {
		List<UserLogin> list = userLoginRepo.getAllUser();
		return list;
	}

	@GetMapping("/getUser/{userId}")
	public UserLogin doGetAdmin(@PathVariable int userId) {
		System.out.println(userId + " : user id");
		return (UserLogin) ((Object) userLoginRepo.findById(userId));
	}

	@PostMapping("/getUserByEmail")
	public UserLogin doGetUser(@RequestBody UserLogin loginforregister1) {
		loginforregister1.getUserEmail();
		loginforregister1.getPassword();
		return userLoginRepo.findByEmail(loginforregister1.getUserEmail(),loginforregister1.getPassword());

	}
}