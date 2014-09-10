package com.hp.manner.validator;

import com.hp.manner.model.UserPasswordForm;
import com.hp.manner.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {

    @Autowired
    private UserServiceImpl userService;

    /*
     * This Validator validates just UserPasswordForm instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return UserPasswordForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserPasswordForm userPasswordForm = (UserPasswordForm) target;
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean oldPasswordCorrect = userService.validatePassword(email, userPasswordForm.getOldPassword());

        if(!oldPasswordCorrect) {
            errors.rejectValue("oldPassword", "oldPassword.incorrect");
        }

        if (!userPasswordForm.getConfirmPassword().equals(userPasswordForm.getNewPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.not.match");
        }

        if (userPasswordForm.getNewPassword().equals(userPasswordForm.getOldPassword())) {
            errors.rejectValue("newPassword", "newPassword.not.same");
        }

    }
}
