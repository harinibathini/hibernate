package org.example;

import entity.foreignkeyassociation.Account;
import entity.foreignkeyassociation.Employee;
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
        //System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Account account = new Account();
        account.setAccountNumber("123-345-65454");

        //Add new Employee Object
        Employee emp = new Employee();
        emp.setEmail("harinibathini@gmail.com");
        emp.setFirstName("harini");
        emp.setLastName("bathini");

        //Save Account
        session.saveOrUpdate(account);
        //Save Employee
        emp.setAccount(account);
        session.saveOrUpdate(emp);

        transaction.commit();
        session.close();

    }
}
