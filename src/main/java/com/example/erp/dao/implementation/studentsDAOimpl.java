package com.example.erp.dao.implementation;

import com.example.erp.bean.employee;
import com.example.erp.bean.placement_student;
import com.example.erp.bean.students;
import com.example.erp.dao.studentsDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class studentsDAOimpl implements studentsDAO {

    @Override
    public void addStudents(students s) {

        //Session session = SessionUtils.getSession();

        Session session = SessionUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            //public employee(String first_name, String last_name, String email, String title, String department) {
            //employee emp = new employee(5,"emp5","emp5","emp5@iiitb.org","head","Counseller");

            session.save(s);
            transaction.commit();
            //return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            //return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Object[]> getPlaced_Students() {
        Session session = SessionUtils.getSession();
        //List<students> stds = new ArrayList<>();
        List<Object[]> listResult = null;
        try {
            //for (final Object student : session.createQuery("from students where placement_id is not null").list()) {
            //    stds.add((students) student);
            //}
            System.out.println("Inside studentsDAOimpl.java");
            Query query = session.createQuery("select distinct s.first_name, s.id, o.name from students as s, placement_student as ps, placement as p, organisations as o " +
           "inner join ps.plcmnt inner join p.org inner join ps.stds where s.placement_id = ps.id and ps.acceptance like 'ACCEPT' and s.placement_id  is not null order by s.id");

            //Query query = session.createQuery("select distinct s.first_name, s.id, p.org from students as s, placement_student as ps, placement as p " +
            //        "inner join ps.plcmnt where s.placement_id = ps.id and ps.acceptance like 'ACCEPT' and s.placement_id  is not null order by s.id");


            listResult = query.list();
            /*for(Object[] aRow : listResult){
                students s = (students) aRow[0];
                placement_student ps = (placement_student) aRow[1];
                System.out.println(s.getFirst_name() + " " + s.getId() + " "+ ps.getStudent_id());
            }*/
            System.out.println("size of result: " + listResult.size());
            System.out.println("size of result: " + listResult.get(0)[0]);
            System.out.println("size of result: " + listResult.get(0)[1]);
            System.out.println("size of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }
    /*@Override
    public List<students> getAll() {
        try (Session session = SessionUtils.getSession()) {
            Query query = session.createQuery("from students");
            //query.setParameter("email", student.getEmail());
            //for (final Object fetch : query.list()) {
            //    return (students) fetch;
            //}

            List<students> stds = (List<students>) query.list();
            return stds;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }

        Session session = SessionUtils.getSession()
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from students");
        List<students> stds = (List<students>) query.list();
        transaction.commit();
        return stds;
    }*/

}
