package com.company.demo.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamePattern("%s|name")
@Table(name = "DEMO_CUSTOMER")
@Entity(name = "demo$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -3557666442948947446L;

    @Size(min = 3)
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Min(1)
    @Max(5)
    @Column(name = "GRADE", nullable = false)
    protected Integer grade;

//    @Pattern(regexp = "\\S+@\\S+", message = "{msg://com.company.demo.entity/Customer.email.validationMsg}")
    @Pattern(regexp = "\\S+@\\S+", message = "Invalid email: ${validatedValue}, pattern: {regexp}")
    @Column(name = "EMAIL")
    protected String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }


}