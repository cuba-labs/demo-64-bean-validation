package com.company.demo.core;

import com.company.demo.service.Foo;
import com.haulmont.cuba.core.global.BeanValidation;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Component(FooManager.NAME)
public class FooManager {
    public static final String NAME = "demo_FooManager";

    @Inject
    private BeanValidation beanValidation;

    public String save(Foo foo) {
        // programmatic validation
        Validator validator = beanValidation.getValidator();
        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);

        return violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n"));
    }
}
