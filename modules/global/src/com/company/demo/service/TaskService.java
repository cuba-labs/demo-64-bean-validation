package com.company.demo.service;


import com.company.demo.entity.Task;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface TaskService {
    String NAME = "demo_TaskService";

    @Validated
    @NotNull
    String completeTask(@Size(min = 5) String comment, @NotNull Task task);

    String save(Foo foo);
}