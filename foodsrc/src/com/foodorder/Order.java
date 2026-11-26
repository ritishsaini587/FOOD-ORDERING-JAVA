package com.foodorder;

import java.util.ArrayList;

public class Order {
    private static int nextId = 1;
    private int id;
    private String customerEmail;
    private ArrayList<OrderItem> items;
    private double total;
    private String status;

    public Order(String customerEmail, ArrayList<OrderItem> items, double total) {
        this.id = nextId++;
        this.customerEmail = customerEmail;
        this.items = items;
        this.total = total;
        this.status = "PLACED";
    }

    public int getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public ArrayList<OrderItem> getItems() { return items; }
    public double getTotal() { return total; }
    public String getStatus() { return status; }
}
