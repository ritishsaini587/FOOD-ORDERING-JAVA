package com.foodorder;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addFood(Food food, int quantity) {
        for (CartItem item : items) {
            if (item.getFood().getId() == food.getId()) {
                item.addQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(food, quantity));
    }

    public boolean removeFood(int foodId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getFood().getId() == foodId) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("\n--- Your Cart ---");
        for (CartItem item : items) {
            System.out.println("Food: " + item.getFood().getName());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Price: Rs. " + item.getFood().getPrice());
            System.out.println("Total: Rs. " + item.getTotal());
            total = total + item.getTotal();
        }
        System.out.println("Cart total: Rs. " + total);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
