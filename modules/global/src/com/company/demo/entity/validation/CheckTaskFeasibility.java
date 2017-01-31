package com.company.demo.entity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = TaskFeasibilityValidator.class)
public @interface CheckTaskFeasibility {

    String message() default "{msg://com.company.demo.entity/CheckTaskFeasibility.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
