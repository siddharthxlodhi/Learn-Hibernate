package org.example;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;

public class CachingDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(LAPTOP.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(registry);
        //Session1
        try (Session session = sessionFactory.openSession()) {
            Query q1 = session.createQuery("from Student where rollNo=197");
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, 197);
            Student student1 = session.get(Student.class, 197);//Query firing one time (first level cache)
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        //Session2
        try (Session session1 = sessionFactory.openSession()) {
            Transaction transaction = session1.beginTransaction();
            Student student = session1.get(Student.class, 197);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
