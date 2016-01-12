package com.abroadtalents.vip.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abroadtalents.vip.domain.Admin;
import com.abroadtalents.vip.domain.User;
import com.abroadtalents.vip.repository.AdminRepository;
import com.abroadtalents.vip.repository.UserRepository;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.group.GroupList;

@Service
public class AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);
    private final AdminRepository adminRepository;
	
    @Inject
    private Client client;
    @Inject
    private Application application;
    
    @Inject
    public AdminService(final AdminRepository repository) {
        this.adminRepository = repository;
    }
    @PreAuthorize("hasRole(@roles.ADMIN)")
    public boolean ensureAdmin() {
        // per the @PreAuthorize, can only get in here if an admin
        return true;
    }
    
    @Transactional
    public Admin save(@NotNull @Valid final Admin user) {
        Admin existing = adminRepository.findByName(user.getName());
        if (existing == null) {
            LOGGER.debug("Created {}", user);
            return adminRepository.save(user);
        } else {
        	return null;
        }
    }
    @Transactional(readOnly = true)
    public List<Admin> getList() {
        LOGGER.debug("Retrieving the list of all admins");
        return adminRepository.findAll();
    }

    public void refreshAdminList() {
    	
    }
    public boolean isAdmin(Account account) {
    	if (account.getGroups().getSize() != 0) { //Currently the only group we has is Admin
    		return true;
    	} else {
    		return false;
    	}
    }
}
