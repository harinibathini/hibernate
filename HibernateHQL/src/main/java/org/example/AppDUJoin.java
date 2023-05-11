package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppDUJoin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//Delete Query
        Query query = session.createQuery("delete from Student where course=:x");
        System.out.println("enter the course u want to delete");
        String c = br.readLine();
        query.setParameter("x", c);
        int r = query.executeUpdate();
        System.out.println("Deleted");
        System.out.println(r);
//Update Query
       // Query query1 = session.createQuery("update Student set course='Hibernate_java' where name='Harini'");
       Query query1 = session.createQuery("update Student s set s.course=:c where s.name=:n");
        System.out.println("Enter course name to update");
        String course = br.readLine();
        query1.setParameter("c", course);
        System.out.println("enter name where to update");
        String name = br.readLine();
        query1.setParameter("n", name);
        int r1 = query1.executeUpdate();
        System.out.println("Updated");
        System.out.println(r1);

        //join Query


        transaction.commit();
        session.close();


    }
}
