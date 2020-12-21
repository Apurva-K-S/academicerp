package com.example.erp.dao.implementation;

import com.example.erp.bean.alumni_organisation;
import com.example.erp.bean.employee;
import com.example.erp.bean.organisations;
import com.example.erp.dao.almorgDAO;
import com.example.erp.dao.employeeDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class almorgDAOimpl implements almorgDAO {

    @Override
    public void addAlumni(alumni_organisation ao) {

        //Session session = SessionUtils.getSession();

        Session session = SessionUtils.getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(ao);
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
    public List<Object[]> getAlumni(organisations org) {
        Session session = SessionUtils.getSession();
        //List<students> stds = new ArrayList<>();
        List<Object[]> listResult = null;
        try {
            //for (final Object student : session.createQuery("from students where placement_id is not null").list()) {
            //    stds.add((students) student);
            //}
            System.out.println("Inside almorgDAlOimp.java");
            //Query query = session.createQuery("select distinct s.first_name, s.id, o.name from students as s, placement_student as ps, placement as p, organisations as o " +
            //        "inner join ps.plcmnt inner join p.org inner join ps.stds where s.placement_id = ps.id and ps.acceptance like 'ACCEPT' and s.placement_id  is not null order by s.id");

            //Query query = session.createQuery("select distinct s.first_name, s.id, p.org from students as s, placement_student as ps, placement as p " +
            //        "inner join ps.plcmnt where s.placement_id = ps.id and ps.acceptance like 'ACCEPT' and s.placement_id  is not null order by s.id");

            //Query query = session.createQuery("select distinct ao.alumni_email, ao.alumni_name, o.name from alumni_organisation as ao, organisations as o " +
            //        "inner join ao.org order by o.name");

            //System.out.println("\n choosen org is " + org.getName());
            Query query = session.createQuery("select distinct ao.alumni_name, ao.alumni_email, ao.joining_date, organisations.name from alumni_organisation as ao inner join ao.org organisations" +
                    " where organisations.name =: name order by ao.alumni_name");
            query.setParameter("name", org.getName());

            listResult = query.list();
            /*for(Object[] aRow : listResult){
                students s = (students) aRow[0];
                placement_student ps = (placement_student) aRow[1];
                System.out.println(s.getFirst_name() + " " + s.getId() + " "+ ps.getStudent_id());
            }*/
            System.out.println("size of result: " + listResult.size());
            System.out.println("1st elt of result: " + listResult.get(0)[0]);
            System.out.println("2nd elt of result: " + listResult.get(0)[1]);
            System.out.println("3rd elt of result: " + listResult.get(0)[2]);

            return listResult;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return listResult;
    }
}
