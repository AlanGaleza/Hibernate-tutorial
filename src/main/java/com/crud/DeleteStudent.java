package com.crud;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        //create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            //start transaction
            session.beginTransaction();

            //retrieve student based ib the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            //delete the student object
            //System.out.println("deleting Student..." + myStudent);
            //session.delete(myStudent);

            //delete student id=2
            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
