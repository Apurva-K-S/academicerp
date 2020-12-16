package com.example.erp.dao;

import com.example.erp.bean.employee;

public interface employeeDAO {

    boolean emailVerify(employee emp);
    //boolean registerStudent(employee emp);
    void addEmployee(employee emp);

}
