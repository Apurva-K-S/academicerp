package com.example.erp.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumni_organisation")
public class alumni_organisation {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    //private Integer organisation; // maps to "id" field of organisation. foreign key.
    @ManyToOne
    @JoinColumn(name="organisation")
    private organisations org;

    @Column(name="alumni_name")
    private String alumni_name;

    @Column(name="alumni_email")
    private String alumni_email;

    @Column(name="position")
    private String position;

    @Column(name="joining_date", nullable = false)
    private String joining_date;

    @Column(name="leaving_date", nullable = false)
    private String leaving_date;

    public alumni_organisation() {
    }

    public alumni_organisation(Integer id, organisations o, String alumni_name, String alumni_email, String position, String joining_date, String leaving_date) {
        //this.organisation = organisation;
        this.id = id;
        this.org = o;
        this.alumni_email = alumni_email;
        this.alumni_name = alumni_name;
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

    //public Integer getOrganisation() {
    //    return organisation;
   // }

    //public void setOrganisation(Integer organisation) {
    //    this.organisation = organisation;
    //}

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
    }
}
