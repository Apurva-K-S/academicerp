package com.example.erp.bean;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class organisations {

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer org_id;  // ID for organisation table. maps to org_id of alumni_organisation table.

    @Column(nullable = false)
    private String name;    // name of the organisation.

    private String address;  // address of the organisation.

    public organisations() {
    }

    public organisations(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;  // maps to "organisation" field of placement and to "organisation" field of Alumni_organisation.
    @Column(nullable = false)
    private String name;
    private String address;

    public organisations() {
    }

    public organisations(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
