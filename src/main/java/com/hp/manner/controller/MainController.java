package com.hp.manner.controller;

import com.hp.manner.model.User;
import com.hp.manner.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    private final Logger logger = Logger.getLogger(getClass());

    public static final String HOME_PAGE = "home.html";
    public static final String USER_PROFILE_PAGE = "user-profile.html";

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping({ "/", "/index", "/home" })
    public String renderHomePage(ModelMap modelMap) {
        logger.info("render home page.");
        modelMap.addAttribute("message", "This is home page!");
        return HOME_PAGE;
    }

    @RequestMapping("/user/profile")
    public String renderUserProfilePage(ModelMap modelMap, HttpServletRequest req) {
        logger.info("render user profile page.");
        String email = req.getRemoteUser();
        logger.info("user email is: " + email);
        modelMap.addAttribute("user", userService.getUserByEmail(email));
        return USER_PROFILE_PAGE;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.PUT)
    public String updateUserProfile(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws Exception {
        logger.info("update user's profile.");
        if (bindingResult.hasErrors()) {
            return USER_PROFILE_PAGE;
        }
        userService.updateUserProfile(user);
        return "redirect:/home";
    }

}
