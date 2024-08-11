package com.investpulse.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyOrSpaceOnlyValidator implements ConstraintValidator<NotEmptyOrSpacesOnly, String> {

    @Override
    public void initialize(NotEmptyOrSpacesOnly constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !value.isBlank();
    }
}
