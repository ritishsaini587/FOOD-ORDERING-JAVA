package com.foodorder;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Food> foods = new ArrayList<>();
    private int nextId = 1;

    public Menu() {
        addFood("Veg Burger", "Fast Food", 80);
        addFood("Paneer Pizza", "Pizza", 220);
        addFood("Masala Dosa", "South Indian", 100);
        addFood("White Sauce Pasta", "Italian", 160);
        addFood("Veg Biryani", "Main Course", 140);
        addFood("French Fries", "Snacks", 70);
        addFood("Cold Coffee", "Beverages", 90);
        addFood("Gulab Jamun", "Dessert", 50);
    }

    public void addFood(String name, String category, double price) {
        foods.add(new Food(nextId, name, category, price));
        nextId++;
    }

    public Food findFood(int id) {
        for (Food food : foods) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    public void showMenu() {
        System.out.println("\n--- Food Menu ---");
        for (Food food : foods) {
            System.out.println(food.getId() + " | " + food.getName()
                    + " | " + food.getCategory() + " | Rs. " + food.getPrice());
        }
    }

    public ArrayList<Food> getAllFood() {
        return foods;
    }
}
