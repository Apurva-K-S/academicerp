package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class students implements Serializable {

    @Id
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @Column(name="roll_number", nullable = false, unique = true)
    private String roll_number;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email", nullable = false, unique = true)
    private String email;


    @Column(name="specialisation")
    private String specialisation;

    private Integer placement_id; // maps to "id" field of placement_student;

    public students() {
    }

    public students(Integer id, String roll_number, String first_name, String last_name, String email, String specialisation,
                    Integer placement_id) {

        this.id = id;
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        //this.domain = domain;
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
