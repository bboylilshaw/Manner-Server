package com.hp.manner.validator;

import com.hp.manner.model.ChangePasswordForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ChangePasswordForm.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "oldPassword", "oldPassword.not.null");
        ValidationUtils.rejectIfEmpty(errors, "newPassword", "newPassword.not.null");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "confirmPassword.not.null");

        ChangePasswordForm changePasswordForm = (ChangePasswordForm) obj;

        if (!changePasswordForm.getConfirmPassword().equals(changePasswordForm.getNewPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.not.match");
        }

        if (changePasswordForm.getNewPassword().equals(changePasswordForm.getOldPassword())) {
            errors.rejectValue("newPassword", "newPassword.not.same");
        }

    }
}
