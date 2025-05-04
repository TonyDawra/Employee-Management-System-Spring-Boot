package com.csis231.api.controller;

import com.csis231.api.model.Admin;
import com.csis231.api.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/authenticate") //@loginAdmin
    public Admin authenticate(@Valid @RequestBody Admin admin) {
        return adminService.authenticate(admin);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) {
        Admin savedAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateAdmin(@PathVariable Long id, @Valid @RequestBody Admin adminDetails, BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body("Invalid admin data");
//        }
//        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
//        return ResponseEntity.ok(updatedAdmin);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
//        adminService.deleteAdmin(id);
//        return ResponseEntity.noContent().build();
//    }
}