package org.UI;

import org.DAO.Service;
import org.DAO.ServiceImple;
import org.DTO.Order;
import org.DTO.OrderInfo;
import org.DTO.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    static Scanner scanner=new Scanner(System.in);
    static Service service=new ServiceImple();
    public static void main( String[] args )
    {
        System.out.println("===============================");
        System.out.println("Select Mode of Operation");
        System.out.println("1. DisplayAllProduct");
        System.out.println("2. Place Order");
        System.out.println("3. Cancel Order");
        System.out.println("4. Display Order");
        System.out.println("5. exit");


        int choise=scanner.nextInt();

        switch (choise){
            case 1:
                    displayProducts();
                    break;
            case 2:
                    placeOrder();
                    break;
            case 3:
                    cancelOrder();
                     break;
            case 4:
                     displayOrders();
                    break;
            case 5:
                    System.exit(0);
                    break;
            case 6:
                System.err.println("Invalid Input");
                break;

        }
        main(args);
    }

    private static void displayOrders() {
        System.out.println("===============================\t");
        for (OrderInfo o1:service.displayAllOrders())
        {
            System.out.println(o1.getOrdId()+"\t"+o1.getCustName()+"\t"+o1.getTotalAmount()+"\t"+o1.getProdName()+"\t"+o1.getProdQty());

        }

    }

    private static void cancelOrder() {
        System.out.println("Enter order Id");
        int ordId=scanner.nextInt();
      boolean status=service.cancelOrder(ordId);
      if (status)
          System.out.println("Order cancel sucessful");
      else
          System.out.println("Order Not Canceled");
    }

    private static void placeOrder() {
        System.out.println("Enter Customer Name");
        String cName=scanner.next();
        System.out.println("Enter Product Id");
        int pId=scanner.nextInt();
        System.out.println("Enter Product Qty");
        int qty=scanner.nextInt();

        Order newOrder=new Order(cName,pId,qty);

        boolean status= service.placeOrder(newOrder);

        if (status)
            System.out.println("Order Placed !!");
        else
            System.out.println("Order Not placed");
    }

    private static void displayProducts() {
        List<Product> productList= service.displayAllProducts();
        System.out.println("Product_ID \t ProductName \t ProductPrice");
        for (Product p:productList ) {
            System.out.println(p.getProductId()+" \t\t"+p.getProductName()+"\t\t\t"+p.getProductPrice());
        }

    }
}
