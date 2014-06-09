package com.hp.manner.controller;

import com.hp.manner.model.User;
import com.hp.manner.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public static final String ADMIN_HOME_PAGE = "admin/home.html";
    public static final String ADMIN_USER_MANAGEMENT_PAGE = "admin/user_manage.html";

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping({ "/", "/index", "/home" })
    public String homePage(ModelMap modelMap) {
        modelMap.addAttribute("message", "This is Admin home Page");
        return ADMIN_HOME_PAGE;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userManagePage(ModelMap modelMap) {
        modelMap.addAttribute("message", "This is User management page");
        List<User> allUsers = userService.listAllUsers();
        modelMap.addAttribute("allUsers", allUsers);
        //modelMap.addAttribute("user", new User());
        return ADMIN_USER_MANAGEMENT_PAGE;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) throws Exception {
        userService.addUser(user);
        return "redirect:/admin/users";
    }

}
