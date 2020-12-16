package com.example.erp.service;

import com.example.erp.bean.employee;
import com.example.erp.bean.placement_student;
import com.example.erp.dao.implementation.placStudDAOimpl;
import com.example.erp.dao.placStudDAO;

public class placStudService {

    placStudDAO placStudDAO = (placStudDAO) new placStudDAOimpl();

    public void addPlacStud(placement_student ps){
        placStudDAO.addPlacStud(ps);
    }

}
