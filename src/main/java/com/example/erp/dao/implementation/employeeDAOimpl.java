package com.example.erp.dao.implementation;

import com.example.erp.bean.employee;
import com.example.erp.dao.employeeDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class employeeDAOimpl implements employeeDAO {

    @Override
    public boolean emailVerify(employee emp) {
        Session session = SessionUtils.getSession();
        try {
            if(emp.getDepartment().equals("outreach")) {
                Query query = session.createQuery("from employee where email=:email and first_name =: first_name and department=: dept ");
                query.setParameter("first_name", emp.getFirst_name());
                query.setParameter("email", emp.getEmail());
                query.setParameter("dept", emp.getDepartment());
                if (query.getResultList().size() == 1) {
                    return true;
                }
            }
            else
                return false;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public void addEmployee(employee emp) {

        //Session session = SessionUtils.getSession();

        Session session = SessionUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(emp);
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }finally {
            session.close();
        }
    }
}
