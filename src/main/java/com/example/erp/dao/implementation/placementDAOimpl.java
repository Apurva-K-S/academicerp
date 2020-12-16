package com.example.erp.dao.implementation;

import com.example.erp.bean.employee;
import com.example.erp.bean.placement;
import com.example.erp.dao.placementDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class placementDAOimpl implements placementDAO {

    @Override
    public void addPlacement(placement p) {

        //Session session = SessionUtils.getSession();

        Session session = SessionUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            //public employee(String first_name, String last_name, String email, String title, String department) {
            //employee emp = new employee(5,"emp5","emp5","emp5@iiitb.org","head","Counseller");

            session.save(p);
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
