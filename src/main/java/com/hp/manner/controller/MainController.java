package com.hp.manner.controller;

import com.hp.manner.model.ChangePasswordForm;
import com.hp.manner.model.User;
import com.hp.manner.service.UserServiceImpl;
import com.hp.manner.validator.PasswordValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
            logger.info(binder.getObjectName());
            logger.info("binding password validator.");
            binder.addValidators(new PasswordValidator());
        }
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }


    @ModelAttribute("changePasswordForm")
    public ChangePasswordForm changePasswordForm() {
        return new ChangePasswordForm();
    }

    @RequestMapping({"/", "/index", "/home"})
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
        //BeanUtils.copyProperties(userService.getUser());
        userService.updateUserProfile(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/user/password", method = RequestMethod.GET)
    public String renderChangePasswordPage() {
        logger.info("render change password page.");
        return CHANGE_PASSWORD_PAGE;
    }

    @RequestMapping(value = "/user/password", method = RequestMethod.POST)
    public String changePassword(@Valid @ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm, BindingResult bindingResult) throws Exception {
        logger.info("render change password page.");
        //passwordValidator.validate(changePasswordForm, bindingResult.);
        return CHANGE_PASSWORD_PAGE;
    }

}
