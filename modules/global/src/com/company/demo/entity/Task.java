package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.groups.Default;

import com.company.demo.entity.validation.CheckTaskFeasibility;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.validation.groups.UiCrossFieldChecks;

@Table(name = "DEMO_TASK")
@Entity(name = "demo$Task")
@CheckTaskFeasibility(groups = {Default.class, UiCrossFieldChecks.class})
public class Task extends StandardEntity {
    private static final long serialVersionUID = 2847506760090261780L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Future
    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    protected Date dueDate;

    @Min(0)
    @Max(100)
    @Column(name = "PROGRESS", nullable = false)
    protected Integer progress;

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getProgress() {
        return progress;
    }


}