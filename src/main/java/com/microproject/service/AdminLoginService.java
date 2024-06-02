package com.microproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microproject.model.AdminLogin;
import com.microproject.model.UserLogin;
import com.microproject.repository.AdminLoginRepo;

@Service
public class AdminLoginService {

    @Autowired
    private AdminLoginRepo adminLoginRepository;


    public AdminLogin saveOrUpdateAdmin(AdminLogin adminLogin) {
        return adminLoginRepository.persist(adminLogin);
    }
    public AdminLogin getAdminLoginById(int adminId) {
        return adminLoginRepository.findById(adminId);
    }
    public AdminLogin getUserLoginByEmail(String email,String password) {
        return adminLoginRepository.findByEmail(email, password);
    }

}

