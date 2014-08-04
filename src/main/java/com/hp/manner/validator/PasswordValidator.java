package com.hp.manner.validator;

import com.hp.manner.model.ChangePasswordForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ChangePasswordForm.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "oldPassword", "oldPassword.required");
        ValidationUtils.rejectIfEmpty(errors, "newPassword", "newPassword.required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "confirmPassword.required");

        ChangePasswordForm changePasswordForm = (ChangePasswordForm) obj;

        if (!changePasswordForm.getConfirmPassword().equals(changePasswordForm.getNewPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.not.match");
        }

        if (changePasswordForm.getNewPassword().equals(changePasswordForm.getOldPassword())) {
            errors.rejectValue("newPassword", "newPassword.not.same");
        }

    }
}
