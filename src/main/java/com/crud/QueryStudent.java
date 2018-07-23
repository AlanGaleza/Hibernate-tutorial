package com.crud;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {
    public static void main(String[] args) {
        //create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display students
            displayStudents(theStudents);

            //query students: lastName='ALL'
            theStudents = session.createQuery("from Student s WHERE s.lastName='ALL'").getResultList();

            //display students
            System.out.println("\nThe students who have lastName ALL ");
            displayStudents(theStudents);

            //query students: lastName='ALL' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s WHERE s.lastName='ALL' OR s.firstName='Daffy'").getResultList();

            //display students
            System.out.println("\nThe students who have lastName ALL or firstName Daffy");
            displayStudents(theStudents);

            //query students where email Like '%alan%'
            theStudents = session.createQuery("from Student s where s.email LIKE '%alan%'").getResultList();

            //display students
            System.out.println("\nStudents where email LIke '%alan$'");
            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    public static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
