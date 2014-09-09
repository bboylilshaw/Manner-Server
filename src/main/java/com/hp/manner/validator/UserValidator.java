package com.hp.manner.validator;

import com.hp.manner.model.User;
import com.hp.manner.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserServiceImpl userService;

    /*
     * This Validator validates just User instances
     */
    @Override
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String defaultMessage = "User exists with email " + user.getEmail();
        if (userService.getUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "user.exists", new Object[]{user.getEmail()}, defaultMessage);
        }
    }
}
