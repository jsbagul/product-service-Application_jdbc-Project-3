package org.DTO;

public class OrderInfo {
    private int ordId;
    private String CustName;
    private double totalAmount;
    private String prodName;
    private int prodQty;

    public OrderInfo() {
    }

    public int getOrdId() {
        return ordId;
    }

    public String getCustName() {
        return CustName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getProdName() {
        return prodName;
    }

    public int getProdQty() {
        return prodQty;
    }

    public OrderInfo(int ordId, String custName, double totalAmount, String prodName, int prodQty) {
        this.ordId = ordId;
        CustName = custName;
        this.totalAmount = totalAmount;
        this.prodName = prodName;
        this.prodQty = prodQty;
    }

}
