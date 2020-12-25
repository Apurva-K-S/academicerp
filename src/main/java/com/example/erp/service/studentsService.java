package com.example.erp.service;

import com.example.erp.bean.employee;
import com.example.erp.bean.organisations;
import com.example.erp.bean.students;
import com.example.erp.dao.implementation.studentsDAOimpl;
import com.example.erp.dao.studentsDAO;

import java.util.List;

public class studentsService {

    studentsDAO studentsDAO = (studentsDAO) new studentsDAOimpl();
    public void addStudent(students s){
        studentsDAO.addStudents(s);
    }

    public List<Object[]> getAll (){
        return studentsDAO.getAll();
    }

    public List<Object[]> getPlaced_Students (){
        return studentsDAO.getPlaced_Students();
    }

    public List<Object[]> getNotPlaced_Students (){
        return studentsDAO.getNotPlaced_Students();
    }

    public List<Object[]> getSpecialisation (students st){
        return studentsDAO.getSpecialisation(st);
    }

    public List<Object[]> getStudentsByOrg (organisations org){
        return studentsDAO.getStudentsByOrg(org);
    }

    public List<Object[]> getStudentsByYear (String yr){ return studentsDAO.getStudentsByYear(yr); }

    public List<Object[]> getStudentsByDomain (String dmn){ return studentsDAO.getStudentsByDomain(dmn); }

}
