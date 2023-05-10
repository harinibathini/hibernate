package org.example;

import dao.BookDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Book book = new Book();
        boolean flag = true;
        List<Book> list;

        while(flag){
            System.out.println("-------------------------");
            System.out.println("ENTER YOUR CHOICE");
            System.out.println(" 1 TO INSERT");
            System.out.println(" 2 TO SELECT");
            System.out.println(" 3 TO UPDATE");
            System.out.println(" 4 TO DELETE");
            System.out.println(" 5 TO fetch by RESTRICTION");
            System.out.println(" 6 TO fetch by ORDER");
            System.out.println(" 7 TO SINGLE PROJECTION");
            System.out.println(" 0 TO EXIT");
            System.out.println("-------------------------");
            int choice = Integer.parseInt(br.readLine());

            switch(choice){
                case 1:
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

                    BookDaoImpl.insertRecord(book);
                    break;
                case 2:
                    BookDaoImpl.selectRecord();
                    break;
                case 3:
                    BookDaoImpl.updateRecord();
                    break;
                case 4:
                    BookDaoImpl.deleteRecord();
                    break;
                case 5:
                    System.out.println("Enter price: ");
                    float price = Float.parseFloat(br.readLine());
                    list = BookDaoImpl.fetchByRestriction(price);

                    for(Book book1 : list){
                        System.out.println(book1);
                    }
                    break;
                case 6:
                    System.out.println("Enter order:");
                    String order = br.readLine();
                    System.out.println("Enter column:");
                    String column = br.readLine();

                    list = BookDaoImpl.fetchByOrder(order, column);

                    for(Book book2 : list){
                        System.out.println(book2);
                    }
                    break;
                case 7:
                    BookDaoImpl.singleProjection();
                    break;
                case 0:
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("ENTER A VALID CHOICE");
            }

        }

    }
}
