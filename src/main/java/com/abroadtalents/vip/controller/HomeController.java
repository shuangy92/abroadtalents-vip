package com.abroadtalents.vip.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abroadtalents.vip.domain.User;
import com.abroadtalents.vip.service.AdminService;
import com.abroadtalents.vip.service.UserClicksTodayService;
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
    UserClicksTodayService userClicksTodayService;
    @Inject
    private HttpServletRequest servletRequest;
    
    @RequestMapping("/")
    String home(Model model) throws Exception {    	
    	setUserAttributes(model);
    	model.addAttribute("page", "home");
        return "home";
    }
    @ResponseBody
    @RequestMapping(value = "/click", method = RequestMethod.POST)
    public void showGuestList(Model model, @RequestParam("username") String username) {
    	userClicksTodayService.updataUserClicks(username);
    }

    @RequestMapping("/admin")
    String admin(Model model) throws Exception {
        adminService.ensureAdmin();
        userService.refreshUserList();
        setUserAttributes(model);
        model.addAttribute("page", "admin");
        return "admin";
    }
    @RequestMapping("/account")
    String myAccount(Model model) throws Exception {
    	setUserAttributes(model);
    	model.addAttribute("page", "account");
        return "account";
    }
    @RequestMapping("/report")
    String report(Model model) throws Exception {
    	setUserAttributes(model);
    	model.addAttribute("page", "report");
        return "report";
    }
    
    private User setUserAttributes(Model model) throws Exception {
    	Account account = AccountResolver.INSTANCE.getRequiredAccount(servletRequest);
    	if (account == null) {
    		throw new Exception("Failed to retrieve user account");
    	} 
    	String username = account.getUsername();
		User user = userService.addUser(username);
    	if (adminService.isAdmin(account)) {
    		user.setAdmin();
    	} 
    	user.setClicksToday(userClicksTodayService.getUserClicks(username));
    	model.addAttribute("user", user);
    	return user;
    }
}
