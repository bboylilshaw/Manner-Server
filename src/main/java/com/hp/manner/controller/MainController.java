package com.hp.manner.controller;

import com.hp.manner.model.ChangePasswordForm;
import com.hp.manner.model.UserProfile;
import com.hp.manner.service.UserServiceImpl;
import com.hp.manner.validator.PasswordValidator;
import org.apache.log4j.Logger;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    private final Logger logger = Logger.getLogger(getClass());

    public static final String HOME_PAGE = "home.html";
    public static final String USER_PROFILE_PAGE = "user-profile.html";
    public static final String CHANGE_PASSWORD_PAGE = "change-password.html";

    @Autowired
    private UserServiceImpl userService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        if (binder.getTarget().getClass().equals(ChangePasswordForm.class)) {
            logger.debug("binding to " + binder.getObjectName());
            logger.info("adding custom password validator");
            binder.addValidators(new PasswordValidator());
        }
    }

    @RequestMapping({"/", "/index", "/home"})
    public String renderHomePage(ModelMap modelMap) {
        logger.info("rendering User home page - " + HOME_PAGE);
        modelMap.addAttribute("message", "This is home page!");
        return HOME_PAGE;
    }

    @RequestMapping("/user/profile")
    public String renderUserProfilePage(ModelMap modelMap, HttpServletRequest req) {
        logger.info("rendering User profile page - " + USER_PROFILE_PAGE);
        String email = req.getRemoteUser();
        logger.debug("user's email is: " + email);
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userService.getUserByEmail(email), userProfile);
        modelMap.addAttribute("userProfile", userProfile);
        return USER_PROFILE_PAGE;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.PUT)
    public String updateUserProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile, BindingResult bindingResult) {
        logger.info("update user's profile.");
        if (bindingResult.hasErrors()) {
            return USER_PROFILE_PAGE;
        }

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        userService.updateUserProfile(email, userProfile);
        return "redirect:/home";
    }

    @RequestMapping(value = "/user/password", method = RequestMethod.GET)
    public String renderChangePasswordPage(ModelMap modelMap) {
        logger.info("rendering change password page - " + CHANGE_PASSWORD_PAGE);
        modelMap.addAttribute("changePasswordForm", new ChangePasswordForm());
        return CHANGE_PASSWORD_PAGE;
    }

    @RequestMapping(value = "/user/password", method = RequestMethod.POST)
    public String changePassword(@Valid @ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm, BindingResult bindingResult) {
        logger.info("update user's password.");
        if (bindingResult.hasErrors()) {
            return CHANGE_PASSWORD_PAGE;
        }

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            userService.updateUserPassword(email, changePasswordForm.getOldPassword(), changePasswordForm.getNewPassword());
        } catch (Exception e) {
            bindingResult.rejectValue("oldPassword", "oldPassword.incorrect", e.getMessage());
            logger.error(e.getStackTrace());
            return CHANGE_PASSWORD_PAGE;
        }
        return "redirect:/home";
    }

}
