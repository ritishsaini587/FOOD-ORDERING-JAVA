package com.foodorder;

import java.util.ArrayList;

public class OrderService {
    public Order placeOrder(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add food first.");
            return null;
        }

        double total = 0;
        ArrayList<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cart.getItems()) {
            Food food = cartItem.getFood();
            int quantity = cartItem.getQuantity();

            total = total + cartItem.getTotal();
            orderItems.add(new OrderItem(food.getName(), food.getPrice(), quantity));
        }

        Payment payment = new Payment("Cash on Delivery");
        payment.processPayment();

        Order order = new Order(customer.getEmail(), orderItems, total);

        System.out.println("\nOrder placed successfully!");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Total: Rs. " + order.getTotal());
        System.out.println("Payment: " + payment.getMethod());
        System.out.println("Payment status: " + payment.getStatus());

        cart.clear();
        return order;
    }

    public void showOrders(Customer customer, ArrayList<Order> allOrders) {
        boolean found = false;
        System.out.println("\n--- Previous Orders ---");

        for (Order order : allOrders) {
            if (order.getCustomerEmail().equalsIgnoreCase(customer.getEmail())) {
                System.out.println("Order ID: " + order.getId()
                        + " | Total: Rs. " + order.getTotal()
                        + " | Status: " + order.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("You have not placed any orders yet.");
        }
    }
}
