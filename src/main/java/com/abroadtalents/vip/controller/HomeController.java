package com.abroadtalents.vip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
class HomeController {
 
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
