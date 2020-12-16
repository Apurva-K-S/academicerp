package com.example.erp.service;

import com.example.erp.bean.placement;
import com.example.erp.dao.implementation.placementDAOimpl;
import com.example.erp.dao.placementDAO;

public class placementService {
    placementDAO placementDAO = (placementDAO) new placementDAOimpl();
    public void addPlacement(placement p){
        placementDAO.addPlacement(p);
    }
}
