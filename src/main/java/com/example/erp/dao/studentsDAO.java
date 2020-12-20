package com.example.erp.dao;

import com.example.erp.bean.employee;
import com.example.erp.bean.students;

import java.util.List;

public interface studentsDAO {
    void addStudents(students s);
    List<Object[]> getPlaced_Students();
    //List<students> getAll();
}
