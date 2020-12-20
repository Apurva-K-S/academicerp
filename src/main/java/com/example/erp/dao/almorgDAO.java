package com.example.erp.dao;

import com.example.erp.bean.alumni_organisation;
import com.example.erp.bean.employee;
import com.example.erp.bean.organisations;

import java.util.List;

public interface almorgDAO {

    void addAlumni(alumni_organisation ao);

    List<Object[]> getAlumni(organisations org);
}
