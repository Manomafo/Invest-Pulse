package com.investpulse.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = NotEmptyOrSpaceOnlyValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyOrSpacesOnly {

    String message() default "O campo não pode ser apenas o caracater de spaço ou vazio";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
