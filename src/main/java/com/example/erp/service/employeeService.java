package com.example.erp.service;

import com.example.erp.bean.employee;
import com.example.erp.dao.employeeDAO;
import com.example.erp.dao.implementation.employeeDAOimpl;

public class employeeService {

    employeeDAO empDAO = (employeeDAO) new employeeDAOimpl();

    public boolean verifyEmail(employee emp){
        return empDAO.emailVerify(emp);
    }
    public void addEmployee(employee emp){
        empDAO.addEmployee(emp);
    }
}
