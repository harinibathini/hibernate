package org.example;

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
        Customer customer = new Customer();
        Product product = new Product();
        boolean flag = true;
        List<Customer> list;

        while(flag){
            System.out.println("-------------------------");
            System.out.println("ENTER YOUR CHOICE");
            System.out.println(" 1 TO INSERT");
            System.out.println(" 2 TO SELECT");
            System.out.println(" 3 TO UPDATE");
            System.out.println(" 4 TO DELETE");
            System.out.println(" 5 TO INSERT Product");
            System.out.println(" 6 TO SELECT Product");
            System.out.println(" 7 TO UPDATE Product");
            System.out.println(" 8 TO DELETE Product");

            System.out.println(" 0 TO EXIT");
            System.out.println("-------------------------");
            int choice = Integer.parseInt(br.readLine());

            switch(choice){
                case 1:
                    System.out.println("Enter customerId:");
                   customer.setCustomerId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter customerName:");
                   customer.setCustomerName(br.readLine());
                    System.out.println("Enter customerPassword:");
                    customer.setCustomerPassword(br.readLine());

                   CustomerImpl.insertRecord(customer);
                    break;
                case 2:
                   CustomerImpl.selectRecord();
                    break;
                case 3:
                    CustomerImpl.updateRecord();
                    break;
                case 4:
                    CustomerImpl.deleteRecord();
                    break;
                case 5:
                    System.out.println("Enter productId:");
                    customer.setCustomerId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter productName:");
                    customer.setCustomerName(br.readLine());
                    System.out.println("Enter price:");
                    customer.setCustomerId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter quantity:");
                    customer.setCustomerId(Integer.parseInt(br.readLine()));

                    ProductImpl.insertRecord(product);
                    break;
                case 6:
                    ProductImpl.selectRecord();
                    break;
                case 7:
                    ProductImpl.updateRecord();
                    break;
                case 8:
                    ProductImpl.deleteRecord();
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
