package com.abroadtalents.vip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abroadtalents.vip.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByName(String name);
}
