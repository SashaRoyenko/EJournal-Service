package com.robosh.ejournal.util.validation.annotation;

import com.robosh.ejournal.util.validation.UniqueFieldValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueFieldValidator.class)
public @interface Unique {

    String message() default "Field is already exist";

    String table();

    String column();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
