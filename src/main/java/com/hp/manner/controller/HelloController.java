package com.hp.manner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        modelMap.addAttribute("title", "Spring Security");
        modelMap.addAttribute("message", "This is welcome page!");
        return "home";

    }

    @RequestMapping({ "/admin/**" })
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("title", "Spring Security Hello World");
        modelMap.addAttribute("message", "This is protected page - Admin Page!");
        return "jsp/admin";

    }

}
