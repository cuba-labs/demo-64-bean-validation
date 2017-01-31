package com.company.demo.web.task;

import com.company.demo.entity.Task;
import com.company.demo.service.Foo;
import com.company.demo.service.TaskService;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class TaskBrowse extends AbstractLookup {

    @Inject
    private TaskService taskService;

    @Inject
    private GroupDatasource<Task, UUID> tasksDs;

    public void complete() {
        String result = taskService.completeTask("The task is done", tasksDs.getItem());
        showNotification(result, NotificationType.TRAY);
    }

    public void saveFoo() {
        Foo foo = new Foo();
        foo.setName("aa");
        foo.setValue(100);
        String result = taskService.save(foo);
        showNotification("Result", result, NotificationType.WARNING);
    }
}