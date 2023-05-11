package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateObjectStatesDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //creating student object
        Student student = new Student();
        student.setId(131);
        student.setName("Bubby");
        student.setCity("Hyd");
        student.setCertificate(new Certificate("Hibernate", "2 months"));
        //Transient state

        session.save(student);
       //Persistent state - session object gets stored,database table created

        student.setName("John");

        transaction.commit();
        session.close();

        student.setName("Ram");
        System.out.println(student);
        //DetachedState : present in database, but the new value will not get reflected as session got closed

        //RemovedState:if we remove data from table/database but session is still active
    }
}
