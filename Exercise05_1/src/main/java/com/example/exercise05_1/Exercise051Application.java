package com.example.exercise05_1;

import com.example.exercise05_1.domain.Customer;
import com.example.exercise05_1.domain.Order;
import com.example.exercise05_1.domain.OrderLine;
import com.example.exercise05_1.domain.Product;
import com.example.exercise05_1.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Exercise051Application {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Customer.class,
            Order.class,
            OrderLine.class,
            Product.class));

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
            Product product=new Product();
            product.setName("Mac Book Pro");
            product.setDescription("Apple Product 13 inches with intel chip");
            session.save(product);

            Product product1=new Product();
            product1.setName("Airpod");
            product1.setDescription("Airpod pro max");
            session.save(product1);

             /*
            OrderLine
             */
            OrderLine orderLine1=new OrderLine();
            orderLine1.setProduct(product);

            OrderLine orderLine2=new OrderLine();
            orderLine2.setProduct(product1);

            session.save(orderLine1);
            session.save(orderLine2);

            /*
            Order
             */
            Order order1=new Order();
            order1.setDate(new Date());
            order1.setOrderId("123");
            order1.setOrderLineList(Arrays.asList(orderLine1,orderLine2));
            session.save(order1);

            Order order2=new Order();
            order2.setDate(new Date());
            order2.setOrderId("456");
            order2.setOrderLineList(Arrays.asList(orderLine1));
            session.save(order2);

            /*
            CUstomer
             */
            Customer customer=new Customer();
            customer.setFirstName("Sauravi");
            customer.setLastName("Thapa");
            customer.setOrderList(Arrays.asList(order1,order2));
            session.save(customer);

            tx.commit();
        }catch (HibernateException ex){
            tx.rollback();
            System.out.println(ex.getMessage());
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
