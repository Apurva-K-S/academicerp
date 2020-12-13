package com.example.erp.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class students {

   /* @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer student_id;

    @Column(unique = true, nullable = false)
    private String roll_number;   // MT2020011/ MT2020005 etc.

    @Column(nullable = false)
    private String first_name;
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    private String domain;    // like MTCSE2020/MTCSE2019/MSCSE2019 etc. string values. drop down in front end.
    private String Specialisation;   // like AIML/TSCD/NC etc.

    private Integer placement_id;  // maps to placement_id in placement.java .

        If null then student not placed. Else student is placed. This can be string or int.
        Here placement_id can be string or integer. I chose it to be Integer.

        Is it okay??



        Here there are fields: photograph_path, cgpa, total_credits, graduation_year.
        But these are not useful for this usecase. Thus we are not including them here.


    public students() {
    }

    public students(String roll_number, String first_name, String last_name, String email, String domain, String specialisation, Integer placement_id) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.domain = domain;
        Specialisation = specialisation;
        this.placement_id = placement_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSpecialisation() {
        return Specialisation;
    }

    public void setSpecialisation(String specialisation) {
        Specialisation = specialisation;
    }

    public Integer getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Integer placement_id) {
        this.placement_id = placement_id;
    } */

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;  // maps to "student_id" of placement_student.
    @Column(nullable = false, unique = true)
    private String roll_number;
    @Column(nullable = false)
    private String first_name;
    private String last_name;
    @Column(nullable = false, unique = true)
    private String email;
    private String domain;
    private String specialisation;
    private Integer placement_id; // maps to "id" field of placement_student;

    public students() {
    }

    public students(String roll_number, String first_name, String last_name, String email, String domain, String specialisation, Integer placement_id) {
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.domain = domain;
        this.specialisation = specialisation;
        this.placement_id = placement_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Integer getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Integer placement_id) {
        this.placement_id = placement_id;
    }
}
