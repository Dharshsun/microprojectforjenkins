package com.microproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_User")
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;
	@Column(name="UserEmail")
	private String userEmail;
	@Column(name="UserName")
	private String userName;
	@Column(name="Password")
	private String password;
	@Column(name="ConfirmPassword")
	private String confirmPassword;
	
	
	public UserLogin() {
		super();
	}


	public UserLogin(int userId, String userEmail, String userName, String password, String confirmPassword) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public UserLogin persist(UserLogin userLogin) {
		return userLogin;
	}
	
	
	
	

	
}
