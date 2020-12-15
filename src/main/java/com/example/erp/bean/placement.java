package com.example.erp.bean;

import javax.persistence.*;

@Entity
@Table(name = "placement")
public class placement {

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