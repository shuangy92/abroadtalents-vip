package com.abroadtalents.vip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abroadtalents.vip.domain.UserClicksToday;

public interface UserClicksTodayRepository extends JpaRepository<UserClicksToday, String> {
    @Modifying //(clearAutomatically = true)
    @Query("UPDATE UserClicksToday uct SET uct.clicks = uct.clicks + 1 WHERE uct.username = ?1")
    public int updateClicks(String username);
}
