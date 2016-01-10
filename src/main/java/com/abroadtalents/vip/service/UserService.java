package com.abroadtalents.vip.service;

import java.util.List;

import com.abroadtalents.vip.domain.User;

public interface UserService {

    User save(User user);

    List<User> getList();

}
