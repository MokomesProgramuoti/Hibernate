package com.minvydas.hibernate.demo;

import com.minvydas.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SourceType;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by Minv1s on 16/08/22.
 */
public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").list();

            //display the students
            displayTheStudents(theStudents);

            //query students: lastname = 'doe'
            theStudents = session.createQuery("from Student s where s.lastname='doe'").list();

            //display the students
            System.out.println("\n\nStudents with last name of doe");
            displayTheStudents(theStudents);

            // query students lastname=doe, or firstname=daffy
            theStudents = session.createQuery("from Student s where s.lastname='doe' OR s.firstname='daffy'").list();

            //display students name=doe, firstname=daffy
            System.out.println("\n\nStudents with lastname doe OR firstname = daffy");
            displayTheStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();
            displayTheStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            factory.close();
        }

    }

    private static void displayTheStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
