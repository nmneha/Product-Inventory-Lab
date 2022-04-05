package io;

import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner userInput = new Scanner(System.in);
    static IceCreamService iceCreamService = new IceCreamService();
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

//    public static void selectMenu(int number) {
//        if (number == 1) {
//            create();
//        } else if (number == 2) {
//            read();
//        } else if (number == 3) {
//            update();
//        } else if (number == 4) {
//            delete();
//        } else if (number == 5) {
//            get();
//        } else if (number == 6) {
//            exit();
//        } else if (number > 6 || number < 0) {
//            System.out.println("Invalid entry. Please pick a number from the menu above");
//        }
//    }

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
        while (size != "12 IN ROUND" || size != "6 IN ROUND") {
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
                "Which inventory would you like to look at?:" +
                "\n1. Ice Cream" +
                "\n2. Cake");
    }

    public void readIceCream() {
        IceCream[] array = iceCreamService.findAllIceCream();
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                IceCream ic = array[i];
                iceCreamService.printIceCream(ic);
            }
        } else {
            System.out.println("There is no inventory for this product.");
        }
    }

    public void readCake() {
        Cake[] array = cakeService.findAll();
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                Cake c = array[i];
                cakeService.printCake(c);
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
        while (choice != 1 || choice != 2) {
            choice = userInput.nextInt();
        }
        return choice;
    }

    public void updateCake() {
        System.out.println("Would you like to see your current inventory?");
    }

    public void updateIceCream() {

    }


    public static void delete() {

    }

    public static void get() {

    }

    public static void exit() {

    }

    public static Double cakePrice(String size) {
       if (size.equals("12 IN ROUND")) {
           return 24.99;
       } else if (size.equals("6 IN ROUND")) {
           return 12.99;
       }
       return null;
    }
}
