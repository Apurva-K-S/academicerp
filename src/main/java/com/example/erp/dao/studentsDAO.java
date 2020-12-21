package com.example.erp.dao;

import com.example.erp.bean.employee;
import com.example.erp.bean.organisations;
import com.example.erp.bean.students;

import java.util.List;

public interface studentsDAO {
    void addStudents(students s);

    List<Object[]> getAll();
    List<Object[]> getPlaced_Students();
    List<Object[]> getSpecialisation(students st);

    List<Object[]> getStudentsByOrg(organisations org);

    List<Object[]> getStudentsByYear(String yr);

    List<Object[]> getStudentsByDomain(String dmn);
    List<Object[]> getNotPlaced_Students();
    //List<students> getAll();
}
