package org.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
//
//        Saving
//        StudentName studentName = new StudentName("SId", "Singh", "lodhi");
//        Student student = new Student();
//        student.setName(studentName);
//        student.setAge(18);
//        student.setRollNo(197);
//        student.setGender("M");
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(student);
//        transaction.commit();

//        Fetching
//        Student student = null;
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            student = session.get(Student.class, 197);
//            transaction.commit();
//            System.out.println(student);
//        } catch (HibernateException e) {
//            System.out.println("error");
//        }
    }
}