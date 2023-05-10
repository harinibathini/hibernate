package dao;

import org.example.Book;
import org.example.DeletedBook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDaoImpl{
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void insertRecord(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(book);
        transaction.commit();
        session.close();
    }
    public static void selectRecord() {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            List<Book> bookList = new ArrayList<Book>();

            try{
                Query query = session.createSQLQuery("from bookcrud");
                bookList = query.getResultList();

                Iterator iterator = bookList.listIterator();
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

        Book book = session.get(Book.class, id);

        System.out.println("Enter bookName:");
        book.setBookName(br.readLine());
        System.out.println("Enter authorName:");
        book.setAuthorName(br.readLine());
        System.out.println("Enter publisherName:");
        book.setPublisherName(br.readLine());
        System.out.println("Enter publishYear:");
        book.setPublishYear(Integer.parseInt(br.readLine()));
        System.out.println("Enter price:");
        book.setPrice(Float.parseFloat(br.readLine()));

        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
    }

    public static void deleteRecord() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter id to be deleted:");
        int id = Integer.parseInt(br.readLine());
        DeletedBook deletedBook = new DeletedBook();
        Book book = session.get(Book.class, id);

        deletedBook.setId(book.getId());
        deletedBook.setBookName(book.getBookName());
        deletedBook.setAuthorName(book.getAuthorName());
        deletedBook.setPublisherName(book.getPublisherName());
        deletedBook.setPublishYear(book.getPublishYear());
        deletedBook.setPrice(book.getPrice());

        session.save(deletedBook);

        session.delete(book);

        transaction.commit();
        session.close();
    }

   public static List<Book> fetchByRestriction(float price){
        Session session = sessionFactory.openSession();

       Criteria criteria = session.createCriteria(Book.class);
       criteria.add(Restrictions.gt("price",price));

       return criteria.list();
   }
   public static List<Book> fetchByOrder(String order, String pnOrColumn){
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Book.class);

        if(order.equalsIgnoreCase("asc")){
            criteria.addOrder(Order.asc(pnOrColumn));
        }else if(order.equalsIgnoreCase("desc")){
            criteria.addOrder(Order.desc(pnOrColumn));
        }
        return criteria.list();
   }
   public static void singleProjection() throws IOException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       System.out.println("Enter property name to fetch records:");
       String propertyName = br.readLine();
       String propertyName1 = br.readLine();

       Criteria criteria = session.createCriteria(Book.class);
       criteria.setProjection(Projections.property(propertyName));
       criteria.setProjection(Projections.property(propertyName1));

       List<Object> result = criteria.list();

       for(Object price : result){
           System.out.println("Property Name: "+result);
       }
       transaction.commit();
       session.close();
   }

}




//Update particular ids
//        try{
//            Query query = session.createSQLQuery("update bookcrud set "+ book.getPrice() +" = :p where id = :bid");
//            query.setParameter("p", book.getPrice());
//            query.setParameter("bid", id);
//            int result = query.executeUpdate();
//            transaction.commit();
//        }
//        catch(Exception e){
//            if(transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }

