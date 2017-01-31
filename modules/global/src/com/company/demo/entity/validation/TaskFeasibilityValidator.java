package com.company.demo.entity.validation;

import com.company.demo.entity.Task;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.TimeSource;
import org.apache.commons.lang.time.DateUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class TaskFeasibilityValidator implements ConstraintValidator<CheckTaskFeasibility, Task> {

    @Override
    public void initialize(CheckTaskFeasibility constraintAnnotation) {
    }

    @Override
    public boolean isValid(Task value, ConstraintValidatorContext context) {
        Date now = AppBeans.get(TimeSource.class).currentTimestamp();
        return !(value.getDueDate().before(DateUtils.addDays(now, 3)) && value.getProgress() < 90);
    }
}
