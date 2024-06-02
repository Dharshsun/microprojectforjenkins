package com.microproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microproject.model.AdminLogin;
import com.microproject.repository.AdminLoginRepo;

@Service
public class AdminLoginServiceImpl extends AdminLoginService {

    @Autowired
    private AdminLoginRepo adminLoginRepository;

    public AdminLogin saveOrUpdateAdmin(AdminLogin adminLogin) {
        return adminLoginRepository.persist(adminLogin);
    }
}

