package com.abroadtalents.vip.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.abroadtalents.vip.domain.User;
import com.abroadtalents.vip.repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountList;
import com.stormpath.sdk.application.*;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    
    @Inject
    private Client client;
    @Inject
    private Application application;
    
    @Inject
    public UserServiceImpl(final UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return userRepository.findAll();
    }

    public String getUsername(Account account) {
    	return account.getUsername();
    }
    public void refreshUserList() {
    	LOGGER.debug("Refreshing user list");
    	AccountList accounts = application.getAccounts();
    	for(Account account : accounts) {
    	    User user = new User(account.getUsername());
    	    this.save(user);
    	}
    }
    public User addUser(Account account) {
    	User user = new User(account.getUsername());
    	LOGGER.debug("Adding {}", user);
    	this.save(user);
    	return user;
    }
    
    @Transactional
    private User save(@NotNull @Valid final User user) {
        User existing = userRepository.findOne(user.getName());
        if (existing == null) {
            LOGGER.debug("Added {}", user);
            return userRepository.save(user);
        } else {
        	return null;
        }
    }

}
