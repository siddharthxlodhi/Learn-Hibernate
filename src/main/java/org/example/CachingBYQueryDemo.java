package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CachingBYQueryDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(LAPTOP.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(registry);
        //Session1
        try (Session session = sessionFactory.openSession()) {
            Query q1 = session.createQuery("from Student where rollNo=197");
            q1.setCacheable(true);
            Transaction transaction = session.beginTransaction();
            Student student = (Student) q1.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        //Session2
        try (Session session1 = sessionFactory.openSession()) {
            Query q2 = session1.createQuery("from Student where rollNo=197");
            q2.setCacheable(true);
            Transaction transaction = session1.beginTransaction();
            Student student = (Student) q2.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
