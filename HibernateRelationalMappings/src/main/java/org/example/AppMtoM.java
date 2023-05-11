package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AppMtoM {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee1 = new Employee();
        employee1.setEid(33);
        employee1.setEname("Harini");

        Employee employee2 = new Employee();
        employee2.setEid(35);
        employee2.setEname("Krati");

        Project project1 = new Project();
        project1.setPid(11);
        project1.setPname("Library Management System");

        Project project2 = new Project();
        project2.setPid(12);
        project2.setPname("Ecom Website");

        List<Employee> listEmp = new ArrayList<Employee>();
        listEmp.add(employee1);
        listEmp.add(employee2);

        List<Project> listProj = new ArrayList<Project>();
        listProj.add(project1);
        listProj.add(project2);

        employee1.setProjects(listProj);
        project2.setEmployees(listEmp);


        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        transaction.commit();
        session.close();
    }
}
