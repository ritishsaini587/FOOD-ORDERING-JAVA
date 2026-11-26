package com.foodorder;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        ArrayList<Order> allOrders = new ArrayList<>();

        while (true) {
            System.out.println("\n===== FOOD ORDERING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");

            int choice = readInt(sc, "Choose: ");

            if (choice == 1) {
                customerService.register(sc);
            } else if (choice == 2) {
                Customer customer = customerService.login(sc);
                if (customer != null) {
                    customerMenu(sc, customer, menu, orderService, allOrders);
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using the application!");
                break;
            } else {
                System.out.println("Please choose from 1 to 3.");
            }
        }

        sc.close();
    }

    private static void customerMenu(Scanner sc, Customer customer, Menu menu,
                                     OrderService orderService, ArrayList<Order> allOrders) {
        Cart cart = new Cart();

        while (true) {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. View food menu");
            System.out.println("2. Add food to cart");
            System.out.println("3. View cart");
            System.out.println("4. Remove item from cart");
            System.out.println("5. Place order (Cash on Delivery)");
            System.out.println("6. View my orders");
            System.out.println("7. Logout");

            int choice = readInt(sc, "Choose: ");

            switch (choice) {
                case 1:
                    menu.showMenu();
                    break;
                case 2:
                    menu.showMenu();
                    int foodId = readInt(sc, "Enter food ID: ");
                    int quantity = readInt(sc, "Enter quantity: ");
                    Food food = menu.findFood(foodId);

                    if (food == null) {
                        System.out.println("Invalid food ID.");
                    } else if (quantity <= 0) {
                        System.out.println("Quantity must be greater than zero.");
                    } else {
                        cart.addFood(food, quantity);
                        System.out.println("Food added to cart.");
                    }
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    int removeId = readInt(sc, "Enter food ID to remove: ");
                    if (cart.removeFood(removeId)) {
                        System.out.println("Item removed.");
                    } else {
                        System.out.println("Food not found in cart.");
                    }
                    break;
                case 5:
                    Order order = orderService.placeOrder(customer, cart);
                    if (order != null) {
                        allOrders.add(order);
                    }
                    break;
                case 6:
                    orderService.showOrders(customer, allOrders);
                    break;
                case 7:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Please choose from 1 to 7.");
            }
        }
    }

    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }
}
