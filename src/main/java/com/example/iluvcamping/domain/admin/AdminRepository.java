package com.example.iluvcamping.domain.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {
    public List<Admin> getAllByAdminIdAndAdminPassword(String id, String password);
}
