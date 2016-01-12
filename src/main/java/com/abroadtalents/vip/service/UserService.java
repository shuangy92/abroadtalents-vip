package com.abroadtalents.vip.service;

import java.util.List;

import com.abroadtalents.vip.domain.User;
import com.stormpath.sdk.account.Account;

public interface UserService {
    List<User> getList();
    String getUsername(Account account);
    void refreshUserList();
    User addUser(Account account);
}
