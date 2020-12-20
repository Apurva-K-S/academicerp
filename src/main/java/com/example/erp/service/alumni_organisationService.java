package com.example.erp.service;

import com.example.erp.bean.alumni_organisation;
import com.example.erp.bean.employee;
import com.example.erp.bean.organisations;
import com.example.erp.dao.almorgDAO;
import com.example.erp.dao.employeeDAO;
import com.example.erp.dao.implementation.almorgDAOimpl;
import com.example.erp.dao.implementation.employeeDAOimpl;

import java.util.List;

public class alumni_organisationService {

    almorgDAO alorgDAO = (almorgDAO) new almorgDAOimpl();

    public void addAlumOrg(alumni_organisation ao){
        alorgDAO.addAlumni(ao);
    }

    public List<Object[]> getAlumni(organisations org){
        return alorgDAO.getAlumni(org);
    }
}
