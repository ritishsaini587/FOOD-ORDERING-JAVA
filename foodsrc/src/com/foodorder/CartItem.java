package com.foodorder;

public class CartItem {
    private Food food;
    private int quantity;

    public CartItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() { return food; }
    public int getQuantity() { return quantity; }

    public void addQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    public double getTotal() {
        return food.getPrice() * quantity;
    }
}
