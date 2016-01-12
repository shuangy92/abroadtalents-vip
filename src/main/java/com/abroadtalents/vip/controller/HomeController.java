package com.abroadtalents.vip.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abroadtalents.vip.domain.User;
import com.abroadtalents.vip.service.AdminService;
import com.abroadtalents.vip.service.UserService;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
@Controller
class HomeController {
 
	@Inject
    AdminService adminService;
	@Inject
    UserService userService;
    @Inject
    private HttpServletRequest servletRequest;
    
    @RequestMapping("/")
    String home(Model model) {    	
    	Account account = AccountResolver.INSTANCE.getRequiredAccount(servletRequest);
    	User user = userService.addUser(account);
    	if (adminService.isAdmin(account)) {
    		user.setAdmin();
    	} 
    	model.addAttribute("user", user);
    	model.addAttribute("page", "home");
        return "home";
    }
    
    @RequestMapping("/admin")
    String admin(Model model) {
        adminService.ensureAdmin();
        userService.refreshUserList();
        model.addAttribute("page", "admin");
        return "admin";
    }
    @RequestMapping("/account")
    String myAccount(Model model) {
    	model.addAttribute("page", "account");
        return "account";
    }
}
