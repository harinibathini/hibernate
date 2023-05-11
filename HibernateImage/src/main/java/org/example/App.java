package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setId(1);
        student.setName("Harini");
        student.setCity("Hyderabad");

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("Hari");
        student1.setCity("Pune");

        Address address = new Address();
        address.setStreet("street1");
        address.setCity("Hyd");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.567);

        Address address1 = new Address();
        address1.setStreet("street2");
        address1.setCity("Pune");
        address1.setOpen(false);
        address1.setAddedDate(new Date());
        address1.setX(123.5);


        FileInputStream fileInputStream = new FileInputStream("src/main/coditaslogo.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        address.setImage(data);

        //Address address1 = new Address(2,"street2","Pune",false,123.9,2023-04-13);

        session.save(student);
        session.save(student1);
        session.save(address);
        session.save(address1);
        transaction.commit();
        session.close();
    }
}
