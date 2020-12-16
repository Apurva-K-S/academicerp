package com.example.erp.service;

import com.example.erp.bean.employee;
import com.example.erp.bean.students;
import com.example.erp.dao.implementation.studentsDAOimpl;
import com.example.erp.dao.studentsDAO;

public class studentsService {

    studentsDAO studentsDAO = (studentsDAO) new studentsDAOimpl();
    public void addStudent(students s){
        studentsDAO.addStudents(s);
    }

}
