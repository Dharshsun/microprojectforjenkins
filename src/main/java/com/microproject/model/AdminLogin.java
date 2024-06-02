package com.microproject.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tbl_adminlogin")
public class AdminLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AdminId")
	private int adminId;
	@Column(name="Email")
	private String email;
	@Column(name="Name")
	private String name;
	@Column(name="Password")
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = UserLogin.class)
	private UserLogin user;
	
	public AdminLogin() {
		super();
	}

	public AdminLogin(int adminId, String email, String name, String password, UserLogin user) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.name = name;
		this.password = password;
		this.user = user;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}

	
	
	
	
	

}
