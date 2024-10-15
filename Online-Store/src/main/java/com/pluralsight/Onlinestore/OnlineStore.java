package com.pluralsight.Onlinestore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    static ArrayList<Products> storeInventory = new ArrayList<>();
    static ArrayList<Products> cart = new ArrayList<>();

    public OnlineStore(ArrayList<Products> storeInventory) {
        this.storeInventory = storeInventory;
        this.cart = new ArrayList<Products>();
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OnlineStore store = new OnlineStore(new ArrayList<Products>());
        getProducts();
        ui(input);


    }

    public static void ui(Scanner input) {
        System.out.print("""
                Hello :) Welcome to Jo's Cafe
                Please pick "Products", "Carts", or "Exit"
                1. Display Products
                2. Display Carts
                3. Exit-closes out of the Application:
                Choose an Option:
                """);
        int userInput = input.nextInt();
        input.nextLine();
        switch (userInput) {
            case 1:
                displayProducts(input);
            case 2:
                displayCart(input);
            case 3:
                break;



        }
    }

    public static void displayProducts(Scanner scanner) {
        for (Products p : storeInventory) {
            System.out.println(p.getName());
            System.out.println("    " + "Sku: " + p.getSku());
            System.out.println("    " + "Price: " + p.getPrice());
            System.out.println("    " + "Department: " + p.getDepartment() + "\n");
        }
        System.out.println("""
                1.Add a product
                2.Search for product
                3.Back to home Screen:
                Choose an Option: 
                """);
        int userInput = scanner.nextInt();
        scanner.nextLine();
        switch (userInput) {
            case 1:
                System.out.println("Product Added: ");
                addToCart(scanner);
                break;
            case 2:
                System.out.println("Search Inventory");
                //       searchInventory(scanner);
                break;
            case 3:
                ui(scanner);
            default:
                displayProducts(scanner);
                System.out.println("\nInvalid Response Needs to be 1-3");
        }
    }

    public static void getProducts() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input = bufferedReader.readLine();
            while ((input = bufferedReader.readLine()) != null) {
                String[] productInfo = input.split("[|]");
                String sku = productInfo[0];
                String productName = productInfo[1];
                double price = Double.parseDouble(productInfo[2]);
                String department = productInfo[3];
                Products product = new Products(department, sku, productName, price);
                storeInventory.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //add items to the cart/////
    public static void addToCart(Scanner scanner) {
        boolean choice = true;
        String skuProduct;
        while (choice) {
            System.out.println("What is the sku for the item that you would like to purchase? ");
            skuProduct = scanner.nextLine();
            boolean foundProduct = false;
            for (Products cartItems : storeInventory) {
                if (cartItems.getSku().equalsIgnoreCase(skuProduct))
                {
                    foundProduct = true;
                    cart.add(cartItems);
                    System.out.println("Product has been added to cart\n");
                    System.out.println(" Would you like to continue shopping Y/N? ");
                    String shoppingChoice = scanner.nextLine();
                if (shoppingChoice.equalsIgnoreCase("Y")) {
                    choice = false;
                    ui(scanner);
                }
                if (!foundProduct)
                    System.out.println(" Sorry, That product is not available\n");
                }


            }


        }

    }

    //Method to remove Product//
    public static void removeProduct(String skuProduct) {
        for (Products products : cart) {
            if (products.getSku().equalsIgnoreCase(skuProduct)) {
                cart.remove(products);
                System.out.println("The Product has been removed\n");
                return;

            }
        }
    }

    //Method for Checkout//
    public static void checkOut() {
        System.out.println(" Would you like to pay with cash or card: ");
        Scanner scanner = new Scanner(System.in);
        String moneyChoice = scanner.nextLine();
        if (moneyChoice.equalsIgnoreCase("cash")) {
            System.out.println(" how much cash would you like to insert: ");
            double amountPaid = scanner.nextDouble();

        } else {
            System.out.println(" Please swipe or tap Card Payment: ");
        }

    }

    //Method for Displaying Cart///
    public static void displayCart(Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println(" Your Cart is empty. ");
            System.out.println(" would you like to see the inventory? Y/N ");
            String inventoryChoice = scanner.nextLine();
            if (inventoryChoice.equalsIgnoreCase("y")) {
                displayProducts(scanner);
            } else {
                ui(scanner);
            }
        } else {
            for (Products items : cart) {
                System.out.println(items.getName());
                System.out.println("  " + "$. " + items.getPrice());
                System.out.println("  " + "Department: " + items.getDepartment());
                System.out.println("  " + "Sku: " + items.getSku() + "\n");
            }
            System.out.printf(" Your total is: $%8.2f\n", calculateTotal());
            System.out.println("""
                    1. Checkout
                    2. Remove Product
                    3. Go back to Home Screen
                    """);
            int checkoutChoice = scanner.nextInt();
            scanner.nextLine();
            switch (checkoutChoice) {
                case 1:
                    checkOut();
                    break;
                case 2:
                    System.out.println("What is the sku of the product you would like removed? ");
                    String skuChoice = scanner.nextLine().trim().toUpperCase();
                    removeProduct(skuChoice);
                    displayCart(scanner);
                    break;
                case 3:
                    ui(scanner);
                    break;

            }

        }


    }

    public static double calculateTotal() {
        double total = 0;
        for (Products items : cart) {
            total += items.getPrice();
        }
        return total;
    }
}



