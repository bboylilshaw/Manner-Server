package com.hp.manner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    public static final String HOME_PAGE = "home";

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        modelMap.addAttribute("title", "Manner - Home");
        modelMap.addAttribute("message", "This is home page!");
        return HOME_PAGE;
    }

}
