package com.example.erp.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "placement_student")
public class placement_student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;  // maps to "placement_id" of student.
    private Integer placement_id;  // maps to "id" of placement.
    private Integer student_id;   // maps to "id" of students
    private String cv_application;
    private String about;
    private String acceptance;
    private String comments;
    private Date date;

    public placement_student() {
    }

    public placement_student(Integer placement_id, Integer student_id, String cv_application, String about, String acceptance, String comments, Date date) {
        this.placement_id = placement_id;
        this.student_id = student_id;
        this.cv_application = cv_application;
        this.about = about;
        this.acceptance = acceptance;
        this.comments = comments;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Integer placement_id) {
        this.placement_id = placement_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getCv_application() {
        return cv_application;
    }

    public void setCv_application(String cv_application) {
        this.cv_application = cv_application;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
