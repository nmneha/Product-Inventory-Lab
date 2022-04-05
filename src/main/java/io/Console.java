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
                return userInput.next();
            } catch (InputMismatchException e) {
                System.out.println("\"" + userInput.next() + "\" isn't a valid input!");
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

    public static void selectMenu(int number) {
        if (number == 1) {
            create();
        } else if (number == 2) {
            read();
        } else if (number == 3) {
            update();
        } else if (number == 4) {
            delete();
        } else if (number == 5) {
            get();
        } else if (number == 6) {
            exit();
        } else if (number > 6 || number < 0) {
            System.out.println("Invalid entry. Please pick a number from the menu above");
        }
    }

    public static void create() {
        System.out.println("Welcome to Product Create Center"+
                "\nSelect new product type: " +
                "\n1. Ice Cream" +
                "\n2. Cake");
    }

    public static void read() {
        System.out.println("Welcome to Inventory Reader" +
                "Which inventory would you like to look at?:" +
                "\n1. Ice Cream" +
                "\n2. Cake");
    }

    public static void update() {

    }

    public static void delete() {

    }

    public static void get() {

    }

    public static void exit() {

    }

    public static void cakeFlavor() {
        System.out.println("What flavor is the cake?");
    }

    public static void  cakeSize() {
        System.out.println("What size cake is it?" +
                "\n[12 IN ROUND]" +
                "\n[6 IN ROUND]");
    }

    public static Double cakePrice(String size) {
       if (size.equals("12 IN ROUND")) {
           return 24.99;
       } else if (size.equals("6 IN ROUND")) {
           return 12.99;
       }
       return null;
    }

    public void iceCreamBrand() {
        System.out.println("Enter the brand");
    }

    public void iceCreamFlavor() {
        System.out.println("What flavor is it?");
    }

    public void iceCreamSize() {
        System.out.println("Enter a size.");
    }
}
