package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Student student = null;
        LAPTOP laptop = null;

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(LAPTOP.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(registry);
//       LAZY FETCH
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            student = session.get(Student.class, 197);
//            List<LAPTOP> laptopList = student.getLaptopList();
//            laptop = session.get(LAPTOP.class, 2020);
//            Student student1 = laptop.getStudent();
//            transaction.commit();
//            System.out.println(student);
//            System.out.println(laptop);
//            System.out.println(laptopList);
//            System.out.println(student1);
//        } catch (HibernateException e) {
//            System.out.println("error");
//        }

//     EAGER FETCH-- @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            student = session.get(Student.class, 197);
            student=session.load(Student.class, 197); //proxy object
            laptop = session.get(LAPTOP.class, 2020);
            transaction.commit();
            System.out.println(student);
            System.out.println(laptop);
        } catch (HibernateException e) {
            System.out.println("error");
        }
    }
}
