package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Admin;
import com.csis231.api.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin authenticate(Admin admin) {
        return adminRepository.getAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword());
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found"));
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Update and delete methods would need to be customized based on the fields of the Admin class
}