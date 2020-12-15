package com.example.erp.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumni_organisation")
public class alumni_organisation {

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
