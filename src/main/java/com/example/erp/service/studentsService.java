package com.example.erp.service;

import com.example.erp.bean.employee;
import com.example.erp.bean.students;
import com.example.erp.dao.implementation.studentsDAOimpl;
import com.example.erp.dao.studentsDAO;

import java.util.List;

public class studentsService {

    studentsDAO studentsDAO = (studentsDAO) new studentsDAOimpl();
    public void addStudent(students s){
        studentsDAO.addStudents(s);
    }

    public List<Object[]> getPlaced_Students (){
        return studentsDAO.getPlaced_Students();
    }
    //public List<students> getAll(){
    //    return studentsDAO.getAll();
    //}

}
