package com.crud;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudent {

    public static void main(String[] args) {
        //create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try {
            //create a student object
            System.out.println("Creating new Student object...");
            Student tempStudent = new Student("Alan", "ALL", "All@alan.com");

            //start transaction
            session.beginTransaction();

            //save the student object
            System.out.println("saving Student...");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
