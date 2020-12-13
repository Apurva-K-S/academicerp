package com.example.erp.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class alumni_organisation {

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer alumni_org_id;   // ID for alumni_org table.

    private Integer org_id;   // maps to org_id in organisations.java

    @Column(nullable = false)
    private String name;    // name of the alumni.

    @Column(nullable = false, unique = true)
    private String email;    // email of the alumni.

        Here as we are not using Alumni Table you told us that instead of "alumni_id" we can have 2 columns: name and email.
        And I thought these cannot be null and email cannot be same I added constraints: nullable and unique.

        Is it okay??


    private String position;   // in which position this person is currently.

    @Column(nullable = false)
    private String joining_date;  // joining date of the student

    @Column(nullable = false)
    private String leaving_date;  // leaving date of the student.

    public alumni_organisation() {
    }

    public alumni_organisation(Integer org_id, String name, String email, String position, String joining_date, String leaving_date) {
        this.org_id = org_id;
        this.name = name;
        this.email = email;
        this.position = position;
        this.joining_date = joining_date;
        this.leaving_date = leaving_date;
    }

    public Integer getAlumni_org_id() {
        return alumni_org_id;
    }

    public void setAlumni_org_id(Integer alumni_org_id) {
        this.alumni_org_id = alumni_org_id;
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public String getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(String leaving_date) {
        this.leaving_date = leaving_date;
    } */

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer organisation; // maps to "id" field of organisation.
    private String alumni_name;
    private String alumni_email;
    private String position;
    @Column(nullable = false)
    private Date joining_date;
    @Column(nullable = false)
    private Date leaving_date;

    public alumni_organisation() {
    }

    public alumni_organisation(Integer organisation, String alumni_name, String alumni_email, String position, Date joining_date, Date leaving_date) {
        this.organisation = organisation;
        this.alumni_name = alumni_name;
        this.alumni_email = alumni_email;
        this.position = position;
        this.joining_date = joining_date;
        this.leaving_date = leaving_date;
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

    public String getAlumni_name() {
        return alumni_name;
    }

    public void setAlumni_name(String alumni_name) {
        this.alumni_name = alumni_name;
    }

    public String getAlumni_email() {
        return alumni_email;
    }

    public void setAlumni_email(String alumni_email) {
        this.alumni_email = alumni_email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public Date getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(Date leaving_date) {
        this.leaving_date = leaving_date;
    }
}
