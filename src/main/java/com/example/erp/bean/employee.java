package com.example.erp.bean;


import sun.util.resources.Bundles;

import javax.persistence.*;

@Entity
public class employee {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer employee_id;

    @Column(nullable = false)
    private String first_name;

    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    private String title;
    private String department;

    public employee() {
    }

    public employee(String first_name, String last_name, String email, String title, String department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        this.department = "outreach";  // as here we have to allow "outreach" department employees only to login. we are fixing it as string.
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

/*
    Doubts:
        Do we have any manytomany relations for this file?
        for primary key is it just mentioning @Id and @GeneratedValue or do we have to do anything else?
        How to specify foreign key of SQL, here ? any annotations?
*/