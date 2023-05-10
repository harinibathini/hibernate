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
import java.util.Iterator;
import java.util.List;

public class CustomerImpl {

        static Configuration configuration = new Configuration().configure();
        static SessionFactory sessionFactory = configuration.buildSessionFactory();
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        public static void insertRecord(Customer customer) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(customer);
            transaction.commit();
            session.close();
        }
        public static void selectRecord() {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            List<Customer> customerList = new ArrayList<Customer>();

            try{
                Query query = session.createSQLQuery("from customer");
                customerList = query.getResultList();

                Iterator iterator = customerList.listIterator();
                while(iterator.hasNext()){
                    System.out.println(iterator.next());
                }
                transaction.commit();
            }
            catch(Exception e){
                if(transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();

            }
            finally {
                session.close();
            }

        }

        public static void updateRecord() throws IOException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            System.out.println("Enter id:");
            int id = Integer.parseInt(br.readLine());
            System.out.println("Enter updated values:");

            Customer customer = session.get(Customer.class, id);

            System.out.println("Enter customerId:");
            customer.setCustomerId(Integer.parseInt(br.readLine()));
            System.out.println("Enter customerName:");
            customer.setCustomerName(br.readLine());
            System.out.println("Enter customerPassword:");
            customer.setCustomerPassword(br.readLine());


            session.saveOrUpdate(customer);
            transaction.commit();
            session.close();
        }

        public static void deleteRecord() throws IOException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            System.out.println("Enter id to be deleted:");
            int id = Integer.parseInt(br.readLine());
            Customer customer;
            customer = session.get(Customer.class, id);


            session.delete(customer);

            transaction.commit();
            session.close();
        }

    }
