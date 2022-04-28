package com.example.exercise05_2_concreteclass;

import com.example.exercise05_2_concreteclass.domain.*;
import com.example.exercise05_2_concreteclass.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Exercise052ConcreteClassApplication {


    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Customer.class,
            Order.class,
            OrderLine.class,
            Product.class,
            CD.class,
            DVD.class,
            Book.class));

    public static void main(String[] args) {

        OrderProduct();
        System.out.println("**********Print Data**********");
        print();
    }

    public static void OrderProduct(){
        Session session=null;
        Transaction tx=null;

        try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            /*
            Product
             */
            CD cd=new CD();
            cd.setName("Rude");
            cd.setDescription("Old Song");
            cd.setArtist("Rihana");
            session.save(cd);

            DVD dvd=new DVD();
            dvd.setName("Lemonade");
            dvd.setDescription("Recent Song");
            dvd.setGenre("RNB");
            session.save(dvd);

            Book book=new Book();
            book.setName("Nothing Last forever");
            book.setDescription("Suspense");
            book.setTitle("Nothing Last forever");
            session.save(book);

             /*
            OrderLine
             */
            OrderLine orderLine1=new OrderLine();
            orderLine1.setProduct(book);

            OrderLine orderLine2=new OrderLine();
            orderLine2.setProduct(dvd);

            OrderLine orderLine3=new OrderLine();
            orderLine3.setProduct(book);

            session.save(orderLine1);
            session.save(orderLine2);
            session.save(orderLine3);

            /*
            Order
             */
            Order order1=new Order();
            order1.setDate(new Date());
            order1.setOrderId("123");
            order1.setOrderLineList(Arrays.asList(orderLine1,orderLine2,orderLine3));
            session.save(order1);


            /*
            CUstomer
             */
            Customer customer=new Customer();
            customer.setFirstName("Sauravi");
            customer.setLastName("Thapa");
            customer.setOrderList(Arrays.asList(order1));
            session.save(customer);

            tx.commit();
        }catch (HibernateException ex){
            tx.rollback();
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }finally {
            session.close();
            System.out.println("Order Product completed, Session closed!!!!!");
        }

    }

    public static void print(){
        Session session=null;
        Transaction tx=null;

        try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            Customer customer=session.get(Customer.class,1L);
            System.out.println("****************************Customer Details****************************");
            System.out.println(customer.toString());
            System.out.println("****************************Customer Ends****************************");

            tx.commit();
        }catch (HibernateException ex){
            tx.rollback();
            System.out.println(ex.getMessage());
        }finally {
            session.close();
            System.out.println("Order Product completed, Session closed!!!!!");
        }
    }

}


