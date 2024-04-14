package com.example.repo7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class RestaurantT {

    // Enum for order status
    enum OrderStatus {
        PLACED, IN_PROGRESS, SERVED, CANCELLED
    }

    // Class representing a menu item
    static class MenuItem {
        private String name;
        private double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    // Class representing an order item
    static class OrderItem {
        private MenuItem menuItem;
        private int quantity;

        public OrderItem(MenuItem menuItem, int quantity) {
            this.menuItem = menuItem;
            this.quantity = quantity;
        }

        public MenuItem getMenuItem() {
            return menuItem;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    // Class representing a table
    static class Table {
        private int number;
        private List<OrderItem> orders;

        public Table(int number) {
            this.number = number;
            this.orders = new ArrayList<>();
        }

        public int getNumber() {
            return number;
        }

        public List<OrderItem> getOrders() {
            return orders;
        }

        public void addOrder(OrderItem orderItem) {
            orders.add(orderItem);
        }
    }

    // Class representing the restaurant
    public static class Restaurant {
        private Map<Integer, Table> tables;
        private Map<String, MenuItem> menu;

        public Restaurant() {
            tables = new HashMap<>();
            menu = new HashMap<>();
        }

        public void addTable(int tableNumber) {
            tables.put(tableNumber, new Table(tableNumber));
        }

        public void addToMenu(String itemName, double price) {
            menu.put(itemName, new MenuItem(itemName, price));
        }

        public void placeOrder(int tableNumber, String itemName, int quantity) {
            Table table = tables.get(tableNumber);
            MenuItem menuItem = menu.get(itemName);
            if (table != null && menuItem != null) {
                OrderItem orderItem = new OrderItem(menuItem, quantity);
                table.addOrder(orderItem);
                System.out.println("Order placed successfully for table " + tableNumber);
            } else {
                System.out.println("Table or menu item not found.");
            }
        }

        // Other methods for managing orders, inventory, billing, etc.

        public static void main(String[] args) {
            Restaurant restaurant = new Restaurant();
            restaurant.addTable(1);
            restaurant.addTable(2);
            restaurant.addToMenu("Burger", 10.99);
            restaurant.addToMenu("Pizza", 12.99);

            // Example usage:
            restaurant.placeOrder(1, "Burger", 2);
            restaurant.placeOrder(2, "Pizza", 1);
        }
    }

}
