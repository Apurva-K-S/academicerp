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
    public boolean emailVerify(employee student) {
        Session session = SessionUtils.getSession();
        try {
            Query query = session.createQuery("from employee where email=:email and department=: dept ");
            query.setParameter("email", student.getEmail());
            query.setParameter("dept", "outreach");
            if(query.getResultList().size()==1){
                return true;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }finally {
            session.close();
        }
        return false;
    }
}
