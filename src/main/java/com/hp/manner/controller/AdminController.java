package com.hp.manner.controller;

import com.hp.manner.model.Role;
import com.hp.manner.model.User;
import com.hp.manner.service.UserServiceImpl;
import com.hp.manner.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private static final String ADMIN_HOME_PAGE = "admin/admin-home.html";
    private static final String ADMIN_USER_MANAGEMENT_PAGE = "admin/user-management.html";

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        if (binder.getTarget() != null && binder.getTarget().getClass().equals(User.class)) {
            logger.debug("binding to " + binder.getObjectName());
            logger.info("add custom user validator");
            binder.addValidators(userValidator);
        }
    }

    @RequestMapping({ "/", "/index", "/home" })
    public String renderAdminHomePage(ModelMap modelMap) {
        logger.info("rendering Admin home page - " + ADMIN_HOME_PAGE);
        modelMap.addAttribute("message", "This is Admin home Page");
        return ADMIN_HOME_PAGE;
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return userService.listAllUsers();
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @RequestMapping("/users")
    public String renderUserManagementPage() {
        logger.info("rendering Admin user management page - " + ADMIN_USER_MANAGEMENT_PAGE);
        return ADMIN_USER_MANAGEMENT_PAGE;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest req, RedirectAttributes redirectAttributes) {
        /*
        * check if there is any binding result errors first.
        * If yes, return to same page with validation error messages.
        * If no, then proceed.
        */
        if (bindingResult.hasErrors()) {
            return ADMIN_USER_MANAGEMENT_PAGE;
        }

        if (req.getParameter("isAdmin") != null ) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }

        logger.info("add new user");
        userService.addUser(user);
        redirectAttributes.addFlashAttribute("message", "Added user successfully!");
        return "redirect:/admin/users";
    }

}
