package com.csis231.api.repository;

import com.csis231.api.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin getAdminByUsernameAndPassword(String username, String password);
}