package com.minvydas.hibernate.demo;

import com.minvydas.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;

/**
 * Created by Minv1s on 16/08/22.
 */
public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //use the session object
            //create a 3 student object
            System.out.println("creating 3 student objects...");
            Student tempStudent1 = new Student("bonita", "applebaum", "bonita@luv2code.com");
            Student tempStudent2 = new Student("john", "doe", "john@luv2code.com");
            Student tempStudent3 = new Student("marry", "public", "marry@luv2code.com");

            //start or begin a transactino
            session.beginTransaction();

            //save the student object
            System.out.println("saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("DONE");

        } finally {
            factory.close();
        }

    }
}
