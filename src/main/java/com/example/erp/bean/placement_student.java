package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "placement_student")
public class placement_student implements Serializable {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="placement_id")
    private placement plcmnt;

    @ManyToOne
    @JoinColumn(name="student_id")
    private students stds;

    //@Column(name="cv_application")
    //private String cv_application;

    //@Column(name="about")
    //private String about;

    @Column(name="acceptance")
    private String acceptance;

    //@Column(name="comments")
    //private String comments;

    @Column(name="date")
    private String date;

    public placement_student() {
    }

    public placement_student(Integer id, placement placement_id, students student_id,  String acceptance,  String date) {

        this.id = id;
        this.plcmnt = placement_id;
        this.stds = student_id;
        //this.cv_application = cv_application;
        //this.about = about;
        this.acceptance = acceptance;
        //this.comments = comments;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public placement getPlacement_id() {
        return plcmnt;
    }

    public void setPlacement_id(placement placement_id) {
        this.plcmnt = placement_id;
    }

    public students getStudent_id() {
        return stds;
    }

    public void setStudent_id(students student_id) {
        this.stds = student_id;
    }

    //public String getCv_application() {
    //    return cv_application;
   // }

    //public void setCv_application(String cv_application) {
     //   this.cv_application = cv_application;
    //}

    //public String getAbout() {
    //    return about;
    //}

    //public void setAbout(String about) {
    //    this.about = about;
    //}

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    //public String getComments() {
    //    return comments;
    //}

    //public void setComments(String comments) {
    //    this.comments = comments;
    //}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
