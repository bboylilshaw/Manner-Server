package com.hp.manner.controller;

import com.hp.manner.model.UserPasswordForm;
import com.hp.manner.model.UserProfileForm;
import com.hp.manner.service.UserServiceImpl;
import com.hp.manner.validator.UserPasswordFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private static final String HOME_PAGE = "home.html";
    private static final String USER_PROFILE_PAGE = "user-profile.html";
    private static final String USER_PASSWORD_PAGE = "user-password.html";

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserPasswordFormValidator userPasswordFormValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        if (binder.getTarget() != null && binder.getTarget().getClass().equals(UserPasswordForm.class)) {
            logger.debug("binding to " + binder.getObjectName());
            logger.info("adding custom password validator");
            binder.addValidators(userPasswordFormValidator);
        }
    }

    @RequestMapping({"/", "/index", "/home"})
    public String renderHomePage(ModelMap modelMap) {
        logger.info("rendering User home page - " + HOME_PAGE);
        modelMap.addAttribute("message", "This is home page!");
        return HOME_PAGE;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public String renderUserProfilePage(ModelMap modelMap) {
        logger.info("rendering user profile page - " + USER_PROFILE_PAGE);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.debug("user's email is: " + email);
        UserProfileForm userProfileForm = new UserProfileForm();
        BeanUtils.copyProperties(userService.getUserByEmail(email), userProfileForm);
        modelMap.addAttribute("userProfileForm", userProfileForm);
        return USER_PROFILE_PAGE;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.PUT)
    public String updateUserProfile(@Valid @ModelAttribute("userProfileForm") UserProfileForm userProfileForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return USER_PROFILE_PAGE;
        }
        logger.info("update user profile");
        userService.updateUserProfile(userProfileForm);
        return "redirect:/";
    }

    @RequestMapping(value = "/user/password", method = RequestMethod.GET)
    public String renderUserPasswordPage(ModelMap modelMap) {
        logger.info("rendering user password page - " + USER_PASSWORD_PAGE);
        modelMap.addAttribute("userPasswordForm", new UserPasswordForm());
        return USER_PASSWORD_PAGE;
    }

    @RequestMapping(value = "/user/password", method = RequestMethod.POST)
    public String updatePassword(@Valid @ModelAttribute("userPasswordForm") UserPasswordForm userPasswordForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return USER_PASSWORD_PAGE;
        }
        logger.info("update user password");
        userService.updateUserPassword(userPasswordForm);
        return "redirect:/";
    }

}
