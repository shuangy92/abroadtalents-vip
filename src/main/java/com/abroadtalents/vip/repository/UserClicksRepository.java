package com.abroadtalents.vip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abroadtalents.vip.domain.UserClicks;

public interface UserClicksRepository extends JpaRepository<UserClicks, String> {
}
