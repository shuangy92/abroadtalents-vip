package com.abroadtalents.vip.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.stormpath.sdk.account.Account;

@Service
@Configuration
public class AdminService {
    
    @PreAuthorize("hasRole(@roles.ADMIN)")
    public boolean ensureAdmin() {
        // per the @PreAuthorize, can only get in here if an admin
        return true;
    }
    
    public boolean isAdmin(Account account) {
    	if (account.getGroups().getSize() != 0) { //Currently the only group we has is Admin
    		return true;
    	} else {
    		return false;
    	}
    }
}
