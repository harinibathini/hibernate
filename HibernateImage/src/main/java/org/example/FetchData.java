package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = (Address) session.load(Address.class,1);
        Address address1 = (Address)session.load(Address.class, 3);

        Student student = (Student) session.get(Student.class, 1);
        Student student1 = (Student) session.get(Student.class, 3);

        Address address2 = (Address)session.load(Address.class, 1);
        Student student2 = (Student)session.load(Student.class, 1);
      //  Student student3 = (Student)session.load(Student.class, 2);
     //   System.out.println(student3);
        //Student student2 = (Student) session.load(Student.class, 9); //throws exceptioin if object not found
        System.out.println(address);
        System.out.println(student);

        System.out.println(address1);
        System.out.println(student1);
        System.out.println(address);
        System.out.println(student2);

        session.save(address);
        session.save(student);
        session.close();

    }
}
