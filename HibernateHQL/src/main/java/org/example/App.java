package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Student student = new Student();
//        student.setId(13);
//        student.setName("Harini");
//        student.setAge(22);
//        student.setCourse("Java");
//
//        Student student1 = new Student(11,"Hari",21,"Hibernate");
//
//        session.save(student);
//        session.save(student1);
//
//        transaction.commit();

//        String query = "from Student";
//        String query = "from Student where course = 'java'";
        String query = "from Student as s where s.course = :x and s.age = :n";
        Query query1 = session.createQuery(query);
        System.out.println("Enter the course you want to retrieve");
        String course = br.readLine();
        query1.setParameter("x", course);
        System.out.println("Enter the age you want to retrieve");
        int age = Integer.parseInt(br.readLine());
        query1.setParameter("n", age);
        //single output - unique
        //multiple output - list
//        System.out.println( query1.getResultList());

        List<Student> list = query1.list();
        for(Student s : list){
            System.out.println(s.getId()+" : "+s.getName());
        }

        session.close();
    }
}
