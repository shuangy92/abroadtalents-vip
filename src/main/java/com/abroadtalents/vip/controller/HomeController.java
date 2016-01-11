package com.abroadtalents.vip.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abroadtalents.vip.service.AdminService;
 
@Controller
class HomeController {
 
	@Inject
    AdminService adminService;
	
    @RequestMapping("/")
    String home() {
        return "home";
    }
    
    @RequestMapping("/admin")
    String admin() {
        adminService.ensureAdmin();
        return "admin";
    }
}
