package com.hp.manner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    public static final String HOME_PAGE = "home.html";

    @RequestMapping({ "/", "/index", "/home" })
    public String indexPage(ModelMap modelMap) {
        modelMap.addAttribute("message", "This is home page!");
        return HOME_PAGE;
    }

}
