package org.DAO;

import org.DTO.Order;
import org.DTO.OrderInfo;
import org.DTO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImple implements Service{
    private static Connection connection;
    static {
        String url="jdbc:mysql://localhost:3306/productDB";
        String user="root";
        String pass="Redminote5@";
        try {
            connection= DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    @Override
    public List<Product> displayAllProducts() {
        List<Product> productList=new ArrayList<>();
       String query="select * from product_info";
        try {
            Statement statement=connection.createStatement();
           ResultSet rs= statement.executeQuery(query);

           while (rs.next()){
                int prodId=rs.getInt(1);
                String prodName=rs.getString(2);
                double prodPrice=rs.getDouble(3);
                int prodQty=rs.getInt(4);
                Product products=new Product(prodId,prodName,prodPrice,prodQty);


                productList.add(products);

           }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return productList;
    }

    @Override
    public boolean placeOrder(Order newOrder) {
     boolean status=false;
     try {
         CallableStatement cstmt=connection.prepareCall("{call placeOrder(?,?,?,?)}");
         cstmt.setString(1, newOrder.getCustomerName());
         cstmt.setInt(2,newOrder.getProductId());
         cstmt.setInt(3,newOrder.getProductQty());

         cstmt.execute();

         status=cstmt.getBoolean(4);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
     return status;
    }

    @Override
    public boolean cancelOrder(int orderId) {
        boolean status=false;
        try {
            CallableStatement cstmt=connection.prepareCall("{call cancelOrder(?,?)}");
            cstmt.setInt(1,orderId);
            cstmt.execute();

            status=cstmt.getBoolean(2);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    @Override
    public List<OrderInfo> displayAllOrders() {
        String query="SELECT \n" +
                "    o.order_id,\n" +
                "    o.customer_name,\n" +
                "    o.product_qty * p.product_price AS total,\n" +
                "    p.product_name,\n" +
                "    o.product_qty\n" +
                "FROM\n" +
                "    order_info o\n" +
                "        INNER JOIN\n" +
                "    product_info p ON p.product_id = o.product_id order by o.order_id;";
        List<OrderInfo> orderList=new ArrayList<>();

        try {
            Statement stmt=connection.createStatement();
          ResultSet rs= stmt.executeQuery(query);
          while (rs.next()){
              OrderInfo orderInfo=new OrderInfo(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5));
              orderList.add(orderInfo);
          }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;

    }
}
