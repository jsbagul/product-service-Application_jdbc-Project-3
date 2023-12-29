package org.DAO;

import org.DTO.Order;
import org.DTO.OrderInfo;
import org.DTO.Product;

import java.util.List;

public interface Service {

    List<Product> displayAllProducts();
    boolean placeOrder(Order newOrder);

    boolean cancelOrder(int orderId);

    List<OrderInfo> displayAllOrders();

}
