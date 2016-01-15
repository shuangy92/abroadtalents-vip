package com.abroadtalents.vip.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    String home(Model model) throws Exception {    	
    	setUserAttribute(model);
    	model.addAttribute("page", "home");
        return "home";
    }
    @ResponseBody
    @RequestMapping(value = "/click")
    public String showGuestList(Model model, @RequestParam("username") String username) {
        //model.addAttribute("guests", hotelService.getGuestsList(surname));
    	//Cookie[] cookies = servletRequest.getCookies(); 
    	//String s = cookies.toString();

        return "10";
    }

    @RequestMapping("/admin")
    String admin(Model model) throws Exception {
        adminService.ensureAdmin();
        userService.refreshUserList();
        setUserAttribute(model);
        model.addAttribute("page", "admin");
        return "admin";
    }
    @RequestMapping("/account")
    String myAccount(Model model) throws Exception {
    	setUserAttribute(model);
    	model.addAttribute("page", "account");
        return "account";
    }
    @RequestMapping("/report")
    String report(Model model) throws Exception {
    	setUserAttribute(model);
    	model.addAttribute("page", "report");
        return "report";
    }
    
    private void setUserAttribute(Model model) throws Exception {
    	Account account = AccountResolver.INSTANCE.getRequiredAccount(servletRequest);
    	if (account == null) {
    		throw new Exception("Failed to retrieve user account");
    	} 
		User user = userService.addUser(account.getUsername());
    	if (adminService.isAdmin(account)) {
    		user.setAdmin();
    	} 
    	model.addAttribute("user", user);
    }
}
