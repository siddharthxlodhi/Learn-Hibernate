package org.example.Hql;

import org.example.LAPTOP;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(registry);
        //Session1
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
//            Query q1 = session.createQuery("select name,age,rollNo from Student");
//            List<java.lang.Object[]> student = (List<Object[]>) q1.list();
//            student.forEach(e ->
//                    {
//                        for (Object o : e) {
//                            System.out.println(o);
//
//                        }
//                    }
//            );
//            int m = 50;
//            String hql = "SELECT name, age, rollNo FROM Student WHERE marks > :m";
//            Query query = session.createQuery(hql);
//            query.setParameter("m", m);
//            List<Object[]> studentList = (List<Object[]>) query.list();
//            studentList.forEach(studentInfo -> {
//                for (Object info : studentInfo) {
//                    System.out.println(info);
//                }
//            });

            //SQL(Native Query)
            SQLQuery sqlQuery = session.createSQLQuery("select * from newstudent where marks>60");
            sqlQuery.addEntity(Student.class);
            List<Student> list = sqlQuery.list();
            list.forEach(e ->
                    System.out.println(e)
            );

            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
