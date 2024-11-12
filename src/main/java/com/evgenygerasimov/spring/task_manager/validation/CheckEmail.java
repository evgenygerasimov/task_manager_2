package com.evgenygerasimov.spring.task_manager.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {
    String message() default "Invalid email. Please use Google email to register. Here is it pattern: your_email@gmail.com";
    String value() default "gmail.com";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
