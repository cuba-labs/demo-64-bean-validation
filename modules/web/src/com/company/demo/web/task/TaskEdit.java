package com.company.demo.web.task;

import com.company.demo.entity.Task;
import com.haulmont.cuba.gui.components.AbstractEditor;

import java.util.Map;

public class TaskEdit extends AbstractEditor<Task> {
    @Override
    public void init(Map<String, Object> params) {
        setCrossFieldValidate(false);
    }
}