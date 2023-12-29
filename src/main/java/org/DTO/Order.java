package org.DTO;

public class Order {
    private int orderId;
    private String CustomerName;
    private int productId;
    private int productQty;

    public Order() {
    }

    public Order (String customerName, int productId, int productQty) {

        CustomerName = customerName;
        this.productId = productId;
        this.productQty = productQty;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
}
