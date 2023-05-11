package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        //Configuration
        //Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


                //BizLogic
        Student student = new Student();

        System.out.println(student);
        System.out.println("*********************");
        student.setId(121);
        student.setName("Coditas");
        student.setMarks(99);
        System.out.println(student);
        System.out.println("*********************");

//        int i = (int) session.save(student);
//        if(i>0){
//            transaction.commit();
//            System.out.println("Done Successfully.......");
//        }
//        else{
//            System.out.println("Try again.......");
//        }
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Done Successfully");
    }

}
