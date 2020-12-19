package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "placement")
public class placement implements Serializable {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    //private Integer organisation;  // maps to "id" of organisations. foreign key.
    @ManyToOne
    @JoinColumn(name="organisation")
    private organisations org;

    @Column(name="profile",nullable = false)
    private String profile;

    @Column(name="description")
    private String description;

    @Column(name="intake", nullable = false)
    private Integer intake;

    @Column(name="minimum_grade")
    private Double minimum_grade;

    public placement() {
    }

    public placement(Integer id, organisations o, String profile, String description, Integer intake, Double minimum_grade) {
        this.id = id;
        this.org = o;
        this.profile = profile;
        this.description = description;
        this.intake = intake;
        this.minimum_grade = minimum_grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public organisations getOrganisation() {
        return org;
    }

    public void setOrganisation(organisations organisation) {
        this.org = organisation;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIntake() {
        return intake;
    }

    public void setIntake(Integer intake) {
        this.intake = intake;
    }

    public Double getMinimum_grade() {
        return minimum_grade;
    }

    public void setMinimum_grade(Double minimum_grade) {
        this.minimum_grade = minimum_grade;
    }
}