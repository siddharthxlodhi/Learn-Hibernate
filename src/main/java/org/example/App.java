package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //Student obj
        StudentName studentName = new StudentName("SId", "Singh", "lodhi");
        Student student = new Student();
        student.setAge(18);
        student.setRollNo(197);
        student.setGender("M");
        LAPTOP laptop = new LAPTOP(1010, "HP VICTUS");
        laptop.setStudent(student);
//        laptop.setStudentList(List.of(student));
        LAPTOP laptop1 = new LAPTOP(2020, "Macbook");
        laptop1.setStudent(student);
//        laptop1.setStudentList(List.of(student));
        student.setName(studentName);
        student.setLaptopList(List.of(laptop, laptop1));


        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(LAPTOP.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(laptop);
        session.save(laptop1);
        transaction.commit();
        session.close();
    }
}
