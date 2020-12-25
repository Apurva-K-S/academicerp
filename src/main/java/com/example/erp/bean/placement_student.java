package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "placement_student")
public class placement_student implements Serializable {

    @Id
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="placement_id")
    private placement plcmnt;

    @ManyToOne
    @JoinColumn(name="student_id")
    private students stds;

    @Column(name="acceptance")
    private String acceptance;


    @Column(name="date")
    private String date;

    public placement_student() {
    }

    public placement_student(Integer id, placement placement_id, students student_id,  String acceptance,  String date) {

        this.id = id;
        this.plcmnt = placement_id;
        this.stds = student_id;
        this.acceptance = acceptance;

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

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
