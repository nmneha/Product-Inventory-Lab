package io;

import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {
    private static Scanner userInput = new Scanner(System.in);
    static IceCreamService iceCreamService = IceCreamService.shared();
    static CakeService cakeService = CakeService.shared();

    public static int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + userInput.next() + "\" isn't a number!");
            }
        }
    }


    //this may not work TODO - make sure you add a condition to catch invalid strings
    public static String getString(String message) {
        while (true) {
            System.out.println(message);
            try {
                return userInput.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\"" + userInput.next() + "\" isn't a valid input!");
            }
        }
    }

    public static double getDouble(String message) {
        while (true) {
            System.out.println(message);
            try {
                return userInput.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\"" + userInput.next() + "\" isn't a number!");
            }
        }
    }


    public static void printWelcome(){
        System.out.println("" +
                "**************************************************" +
                "\n***           Welcome and Bienvenue            ***" +
                "\n***                    to                      ***" +
                "\n***     Sera 'N' Dipity Inventory Manager      ***" +
                "\n**************************************************");
    }

    public static void printMainMenu() {
        System.out.println("MAIN MENU: " +
                "\n1. CREATE NEW PRODUCT" +
                "\n2. READ PRODUCTS" +
                "\n3. UPDATE PRODUCTS" +
                "\n4. DELETE PRODUCTS" +
                "\n5. GET REPORT" +
                "\n6. EXIT");
    }

    public static void create() {
        System.out.println("Welcome to Product Create Center"+
                "\nSelect new product type: " +
                "\n1. Ice Cream" +
                "\n2. Cake");
    }

    public void createIceCream() {
        String brand = getString("Enter the brand");
        String flavor = getString("What flavor is it?");
        String size = getString("Enter a size.");
        int qty = getNumber("How much inventory is there?");
        double price = getDouble("What is the price?");

        iceCreamService.createIceCream(brand, flavor, size, qty, price);
    }


    public void createCake() {
        String flavor = getString("What flavor is the cake?");
        String size = getString("What size cake is it?" +
                "\n[12 IN ROUND]" +
                "\n[6 IN ROUND]");
        while (!size.equals("12 IN ROUND") && !size.equals("6 IN ROUND")) {
            System.out.println("This is not a valid input." +
                    "Please enter a size from above.");
            size = userInput.nextLine();
        }
        int qty = getNumber("How much inventory is there?");
        double price = cakePrice(size);
        cakeService.create(flavor, size, qty, price);
    }

    public static void read() {
        System.out.println("Welcome to Inventory Reader" +
                "\nWhich inventory would you like to look at?:" +
                "\n1. Ice Cream" +
                "\n2. Cake");
    }

    public void readIceCream() {
        System.out.println("\n-------------------------------\n");
        IceCream[] array = iceCreamService.findAllIceCream();
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                IceCream ic = array[i];
                System.out.println(iceCreamService.printIceCream(ic));
            }
        } else {
            System.out.println("There is no inventory for this product.");
        }
    }

    public void readCake() {
        System.out.println("\n-------------------------------\n");
        Cake[] array = cakeService.findAll();
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                Cake c = array[i];
                System.out.println(cakeService.printCake(c));
            }
        } else {
            System.out.println("There is no inventory for this product.");
        }
    }

    public int update() {
        System.out.println("Welcome to the Product Update Center." +
                "\nSelect the inventory you would like to go into" +
                "\n1. Ice Cream" +
                "\n2. Cake");
        int choice = getNumber("ENTER 1 OR 2");
        while (choice <= 0 || choice > 2) {
            choice = getNumber("This is not a valid input. Enter 1 or 2");
        }
        return choice;
    }

    public void updateCake() {
        currentInventory("Cake");
        int exit = cakeService.findAll().length;

        int choice = getNumber("Choose an ID to update the inventory or enter " + 0 + " to exit");
        while (choice < 0 || choice > cakeService.findAll().length) {
            choice = getNumber("This is not a valid ID." +
                    "\nPlease pick an ID from your current product inventory");
        }
        if (choice <= exit && choice > 0) {
            String confirm = "NO";
            while (confirm.equals("NO")) {
                Cake update = cakeService.getInventory().get(choice-1);
                int inventoryUpdate = getNumber("Enter the updated inventory for this item.");
                update.setQty(inventoryUpdate);
                System.out.println("The inventory of item " + update.getId() + " has been updated to " + update.getQty() + "." +
                        "\nIs this correct?");
                confirm = userInput.nextLine();
                yesNO(confirm);
            }
        } else if (choice == 0) {
            System.out.println("See you later.");
        }

    }

    public void updateIceCream() {
        currentInventory("Ice Cream");
        int exit = iceCreamService.findAllIceCream().length;

        int choice = getNumber("Choose an ID to update the inventory or enter " + 0 + " to exit");
        while (choice < 0 || choice > iceCreamService.findAllIceCream().length) {
            choice = getNumber("This is not a valid ID." +
                    "\nPlease pick an ID from your current product inventory");
        }
        if (choice <= exit && choice > 0) {
            String confirm = "NO";
            while (confirm.equals("NO")) {
                IceCream update = iceCreamService.getInventory().get(choice-1);
                int inventoryUpdate = getNumber("Enter the updated inventory for this item.");
                update.setQty(inventoryUpdate);
                System.out.println("The inventory of item " + update.getId() + " has been updated to " + update.getQty() + "." +
                        "\nIs this correct?");
                confirm = userInput.nextLine();
                yesNO(confirm);
            }
        } else if (choice == 0) {
            System.out.println("See you later.");
        }
    }


    public static int delete() {
        System.out.println("Product Deletion Center" +
                "\nPlease pick which inventory you would like to edit." +
                "\n1. Ice Cream" +
                "\n2. Cake");
        int choice = getNumber("ENTER 1 OR 2");
        while (choice <= 0 || choice > 2) {
            choice = getNumber("This is not a valid input. Enter 1 or 2");
        }
        return choice;
    }

    public void deleteIceCream() {
        currentInventory("Ice Cream");
        String confirm = "NO";
        int choice = getNumber("Enter the ID of the item you want to delete " + 0 + " to exit");
        while (choice < 0 || choice > iceCreamService.findAllIceCream().length) {
            choice = getNumber("This is not a valid ID." +
                    "\nPlease pick an ID from your current product inventory");
        }
        confirm = getString("You are about to delete item of ID: " + choice + "." +
                "\nAre you sure you would like to delete this item?" +
                "\nEnter YES to delete or NO to exit");
        while (choice != 0) {
            confirm = yesNO(confirm);
            if (confirm.equals("YES")) {
                iceCreamService.deleteIceCream(choice);
                choice = getNumber("Enter 0 to exit or enter a different ID number to delete.");
            } else {
                choice = getNumber("Enter 0 to exit or enter a different ID number to delete.");
            }
        }
    }

    public void deleteCake() {
        currentInventory("Cake");
        String confirm = "NO";
        int choice = getNumber("Enter the ID of the item you want to delete " + 0 + " to exit");
        while (choice < 0 || choice > cakeService.findAll().length) {
            choice = getNumber("This is not a valid ID." +
                    "\nPlease pick an ID from your current product inventory");
        }
        confirm = getString("You are about to delete item of ID: " + choice + "." +
                "\nAre you sure you would like to delete this item?" +
                "\nEnter YES to delete or NO to exit");
        while (choice != 0) {
            confirm = yesNO(confirm);
            if (confirm.equals("YES")) {
                cakeService.delete(choice);
                choice = getNumber("Enter 0 to exit or enter a different ID number to delete.");
            } else {
                choice = getNumber("Enter 0 to exit or enter a different ID number to delete.");
            }
        }
    }

    public static void get() {

    }

    public static int exit() {
        int exit = getNumber("This is not a valid input." +
                "\nPlease pick a number from the menu above or enter 6 to exit.");
        return exit;
    }

    public static Double cakePrice(String size) {
       if (size.equals("12 IN ROUND")) {
           return 24.99;
       } else if (size.equals("6 IN ROUND")) {
           return 12.99;
       }
       return null;
    }

    public void currentInventory(String product) {
        if (product.equals("Ice Cream")) {
            System.out.println("This is your current inventory: \n");
            System.out.println("\n-------------------------------\n");
            System.out.println(iceCreamService.printAllIceCream());
        } else {
            System.out.println("This is your current inventory: \n");
            System.out.println("\n-------------------------------\n");
            System.out.println(cakeService.printAllCake());
        }
    }

    public String yesNO(String confirm) {
            while (!confirm.equals("YES") && !confirm.equals("NO")) {
                confirm = getString("Please enter YES or NO.");
            }
        return confirm;
    }
}
