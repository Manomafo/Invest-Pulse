package com.investpulse.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;;

@Documented
@Constraint(validatedBy = NotDifferentOfNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotDifferentOfNumber {

    String message() default "O campo deve ter apenas numeros";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
