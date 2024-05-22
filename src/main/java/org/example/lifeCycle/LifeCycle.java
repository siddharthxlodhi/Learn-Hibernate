package org.example.lifeCycle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class LifeCycle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(LAPTOP.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(registry);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            org.example.lifeCycle.LAPTOP laptop=new org.example.lifeCycle.LAPTOP(1221,"asus",50000); //Transient State
            session.save(laptop); //Persistence state
            transaction.commit();
            session.detach(laptop);//Detach state
            laptop.setPrice(60000);

        } catch (HibernateException e) {
            System.out.println("error");
        }
    }
}
