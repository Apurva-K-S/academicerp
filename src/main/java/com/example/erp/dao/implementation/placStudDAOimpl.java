package com.example.erp.dao.implementation;

import com.example.erp.bean.employee;
import com.example.erp.bean.placement_student;
import com.example.erp.dao.placStudDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class placStudDAOimpl implements placStudDAO {

    @Override
    public void addPlacStud(placement_student ps) {

        //Session session = SessionUtils.getSession();

        Session session = SessionUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            //public employee(String first_name, String last_name, String email, String title, String department) {
            //employee emp = new employee(5,"emp5","emp5","emp5@iiitb.org","head","Counseller");

            session.save(ps);
            transaction.commit();
            //return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            //return false;
        }finally {
            session.close();
        }
    }
}
