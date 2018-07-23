package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try {
            //create a student objects
            System.out.println("Creating new Student object...");
            Student tempStudent1 = new Student("Alan", "ALL", "All@alan.com");
            Student tempStudent2 = new Student("Wall", "MARRY", "Wall@alan.com");
            Student tempStudent3 = new Student("John", "DOE", "John@alan.com");

            //start transaction
            session.beginTransaction();

            //save the student object
            System.out.println("saving Students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
