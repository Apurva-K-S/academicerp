package com.example.erp.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class placement {

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer placement_id;  // maps to placement_id in students.java

    private String organisation;  // name of the organisation.

    @Column(nullable = false)
    private String profile;    // SDE/Data Analyst etc.

    private String description;   // description of job.

    @Column(nullable = false)
    private Integer intake;   // number of student intake.

    private Integer minimum_grade;  // minimum grade required.

    public placement() {
    }

    public placement(String organisation, String profile, String description, Integer intake, Integer minimum_grade) {
        this.organisation = organisation;
        this.profile = profile;
        this.description = description;
        this.intake = intake;
        this.minimum_grade = minimum_grade;
    }

    public Integer getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Integer placement_id) {
        this.placement_id = placement_id;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
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

    public Integer getMinimum_grade() {
        return minimum_grade;
    }

    public void setMinimum_grade(Integer minimum_grade) {
        this.minimum_grade = minimum_grade;
    }*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer organisation;  // maps to "id" of organisations.
    @Column(nullable = false)
    private String profile;
    private String description;
    @Column(nullable = false)
    private Integer intake;
    private Integer minimum_grade;

    public placement() {
    }

    public placement(Integer organisation, String profile, String description, Integer intake, Integer minimum_grade) {
        this.organisation = organisation;
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

    public Integer getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Integer organisation) {
        this.organisation = organisation;
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

    public Integer getMinimum_grade() {
        return minimum_grade;
    }

    public void setMinimum_grade(Integer minimum_grade) {
        this.minimum_grade = minimum_grade;
    }
}