package com.example.erp.utils;

import com.example.erp.bean.*;
import com.example.erp.service.*;

import java.util.Date;

public class AddingData {
    public void add()
    {
        employeeService employeeService = new employeeService();
        //employee emp = new employee(6, "emp6", "emp7", "emp7@iiitb.org", "HOD", "Maintenance");
        //employeeService.addEmployee(emp);

        employee emp = new employee(1, "emp1", "emp1", "emp1@iiitb.org", "Professor", "outreach");
        employeeService.addEmployee(emp);
        employee emp1 = new employee(2, "emp2", "emp2", "emp2@iiitb.org", "HOD", "outreach");
        employeeService.addEmployee(emp1);
        employee emp2 = new employee(3, "emp3", "emp3", "emp3@iiitb.org", "professor", "Maintenance");
        employeeService.addEmployee(emp2);

        orgService orgService = new orgService();

        organisations o1 = new organisations(1, "Microsoft", "Bangalore");
        orgService.addOrg(o1);
        organisations o2 = new organisations(2, "Flipkart", "Noida");
        orgService.addOrg(o2);
        organisations o3 = new organisations(3, "Amazon", "Delhi");
        orgService.addOrg(o3);
        organisations o4 = new organisations(4, "HP", "Hyderabad");
        orgService.addOrg(o4);


        alumni_organisationService alorgService = new alumni_organisationService();

        alumni_organisation ao1 = new alumni_organisation(1, o1, "light", "l@xyz.com", "sde2", "2017-12-08", "2020-12-12");
        alorgService.addAlumOrg(ao1);
        alumni_organisation ao2 = new alumni_organisation(2, o1, "lelouch", "le@xyz.com", "research engg", "2018-12-08","2022-12-12");
        alorgService.addAlumOrg(ao2);
        alumni_organisation ao3 = new alumni_organisation(3, o3, "Ryuk", "r@xyz.com", "sde3","2018-12-08", "2023-12-12");
        alorgService.addAlumOrg(ao3);
        alumni_organisation ao4 = new alumni_organisation(4, o4, "Edward", "e@xyz.com", "manager","2018-08-08", "2022-03-20");
        alorgService.addAlumOrg(ao4);
        alumni_organisation ao5 = new alumni_organisation(5, o2, "Jim", "J@xyz.com", "manager","2021-01-12", "2024-03-20");
        alorgService.addAlumOrg(ao5);


        placementService placementService = new placementService();
        placement p1 = new placement(1, o1, "sde", "software development engineer", 10, 2.8 );
        placementService.addPlacement(p1);
        placement p2 = new placement(2, o1, "CSA", "Computer System Analyst", 5, 3.2 );
        placementService.addPlacement(p2);
        placement p3 = new placement(3, o2, "se", "software engineer", 8, null );
        placementService.addPlacement(p3);
        placement p4 = new placement(4, o3, "RS", "Research Scientist", 2,  3.2);
        placementService.addPlacement(p4);
        placement p5 = new placement(5, o3, "CE", "Cloud Engnieer", 10, null );
        placementService.addPlacement(p5);
        placement p6 = new placement(6, o4, "DQE", "Data Quality Engineer", 10, 2.8 );
        placementService.addPlacement(p6);


        studentsService studentsService = new studentsService();

        students s1 = new students(1, "MT2020001", "Clark", "M", "c@iiitb.org", "AIML", 1);
        studentsService.addStudent(s1);
        students s2 = new students(2, "MT2020002", "Bruce", "W", "b@iiitb.org", "NC", 6);
        studentsService.addStudent(s2);
        students s3 = new students(3, "MT2020003", "Diana", "T", "d@iiitb.org", "VLSI", 4);
        studentsService.addStudent(s3);
        students s4 = new students(4, "MT2020004", "Jon", "P", "J@iiitb.org", "TSCD", null);
        studentsService.addStudent(s4);
        students s5 = new students(5, "MT2020005", "Barry", "R", "br@iiitb.org", "AIML", 8);
        studentsService.addStudent(s5);

        placStudService placStudService = new placStudService();
        //public placement_student(Integer id, placement placement_id, students student_id,  String acceptance, String comments, String date) {
        placement_student ps1 = new placement_student(1, p1, s1 , "ACCEPT", "02-11-20020");
        placStudService.addPlacStud(ps1);
        placement_student ps2 = new placement_student(2, p1, s2 , "REJECT", "03-11-20020");
        placStudService.addPlacStud(ps2);
        placement_student ps3 = new placement_student(3, p1, s3 , "REJECT", "03-11-20020");
        placStudService.addPlacStud(ps3);
        placement_student ps4 = new placement_student(4, p2, s3 , "ACCEPT", "10-11-20020");
        placStudService.addPlacStud(ps4);
        placement_student ps5 = new placement_student(5, p3, s4 , "PENDING", "10-12-20020");
        placStudService.addPlacStud(ps5);
        placement_student ps6 = new placement_student(6, p4, s2 , "ACCEPT", "11-12-20020");
        placStudService.addPlacStud(ps6);
        placement_student ps7 = new placement_student(7, p5, s5 , "REJECT", "11-12-20020");
        placStudService.addPlacStud(ps7);
        placement_student ps8 = new placement_student(8, p6, s5 , "ACCEPT", "12-12-20020");
        placStudService.addPlacStud(ps8);

    }
}
