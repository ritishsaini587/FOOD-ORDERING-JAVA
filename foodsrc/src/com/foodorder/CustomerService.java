package com.foodorder;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void register(Scanner sc) {
        System.out.println("\n--- Customer Registration ---");
        System.out.print("Full name: ");
        String name = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter all details.");
            return;
        }

        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                System.out.println("This email is already registered.");
                return;
            }
        }

        customers.add(new Customer(name, email, password));
        System.out.println("Registration successful.");
    }

    public Customer login(Scanner sc) {
        System.out.println("\n--- Customer Login ---");
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine();

        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email)
                    && customer.getPassword().equals(password)) {
                System.out.println("Welcome, " + customer.getName() + "!");
                return customer;
            }
        }

        System.out.println("Invalid email or password.");
        return null;
    }
}
