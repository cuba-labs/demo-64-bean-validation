package com.company.demo.service;

import com.company.demo.core.FooManager;
import com.company.demo.entity.Task;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service(TaskService.NAME)
public class TaskServiceBean implements TaskService {

    @Inject
    private FooManager fooManager;

    @Override
    public String completeTask(@Size(min = 5) String comment, @NotNull Task task) {
        return "Done";
    }

    @Override
    public String save(Foo foo) {
        return fooManager.save(foo);
    }
}