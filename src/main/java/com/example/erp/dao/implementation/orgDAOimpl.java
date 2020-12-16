package com.example.erp.dao.implementation;

import com.example.erp.bean.alumni_organisation;
import com.example.erp.bean.organisations;
import com.example.erp.dao.orgDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class orgDAOimpl implements orgDAO {

    @Override
    public void addOrg(organisations o) {

        Session session = SessionUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(o);
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
