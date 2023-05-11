package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableCode {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setId(12);
        student.setName("Krati");
        student.setCity("Indore");

        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("6 months");

        student.setCertificate(certificate);

        Student student1 = new Student();
        student1.setId(15);
        student1.setName("Shreya");
        student1.setCity("Delhi");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("DS");
        certificate1.setDuration("4 months");

        student1.setCertificate(certificate1);

        Student student2 = new Student();
        student2.setId(15);
        student2.setName("Harini");
        student2.setCity("Hyd");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Java");
        certificate2.setDuration("6 months");

        student2.setCertificate(certificate2);

        session.save(student);
        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();
    }
}
