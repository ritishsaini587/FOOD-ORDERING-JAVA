package com.foodorder;

public class Payment {
    private String method;
    private String status;

    public Payment(String method) {
        this.method = method;
        this.status = "PENDING";
    }

    public void processPayment() {
        if (method.equalsIgnoreCase("Cash on Delivery")) {
            status = "PAY ON DELIVERY";
        }
    }

    public String getMethod() { return method; }
    public String getStatus() { return status; }
}
