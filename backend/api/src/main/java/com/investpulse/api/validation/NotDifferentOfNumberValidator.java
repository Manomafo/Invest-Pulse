package com.investpulse.api.validation;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidator;

public class NotDifferentOfNumberValidator implements ConstraintValidator<NotDifferentOfNumber, String> {

    @Override
    public void initialize(NotDifferentOfNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isNumeric = value.chars().allMatch(Character::isDigit);
        return isNumeric;

    }
}
