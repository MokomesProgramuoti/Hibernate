package com.minvydas.hibernate.demo;

import com.minvydas.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;

/**
 * Created by Minv1s on 16/08/22.
 */
public class DeleteStudentDemo {
    public static void main(String[] args) {
        //create session factory
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = (Student) session.get(Student.class, studentId);


            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
