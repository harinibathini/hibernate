package org.example;

import org.hibernate.*;
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
       //Configuration configuration = new Configuration().configure();
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //BizLogic
        Book book = new Book();
        book.setId(121);
        book.setBookName("Let us C");
        book.setAuthorName("Yashwant Kanetkar");
        book.setPublisherName("Nirali Prakashan");
        book.setPublishYear(1998);
        book.setPrice(450);

        session.save(book);
        transaction.commit();
        session.close();
    }
}
