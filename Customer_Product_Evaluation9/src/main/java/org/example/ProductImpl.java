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

public class ProductImpl {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void insertRecord(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(product);
        transaction.commit();
        session.close();
    }
    public static void selectRecord() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Product> productList = new ArrayList<Product>();

        try{
            Query query = session.createSQLQuery("from customer");
            productList = query.getResultList();

            Iterator iterator = productList.listIterator();
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

        Product product = session.get(Product.class, id);

        System.out.println("Enter productId:");
        product.setProductId(Integer.parseInt(br.readLine()));
        System.out.println("Enter productName:");
        product.setProductName(br.readLine());
        System.out.println("Enter price:");
        product.setPrice(Integer.parseInt(br.readLine()));
        System.out.println("Enter quantity:");
        product.setQuantity(Integer.parseInt(br.readLine()));


        session.saveOrUpdate(product);
        transaction.commit();
        session.close();
    }

    public static void deleteRecord() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter id to be deleted:");
        int id = Integer.parseInt(br.readLine());
        Product product;
        product = session.get(Product.class, id);


        session.delete(product);

        transaction.commit();
        session.close();
    }

}
