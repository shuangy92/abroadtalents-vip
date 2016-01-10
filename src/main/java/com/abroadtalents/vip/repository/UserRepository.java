package com.abroadtalents.vip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abroadtalents.vip.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  User findByName(String name);
}
