package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    Scanner userInput = new Scanner(System.in);

    public int getNumber(String message) {
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
    public String getString(String message) {
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

        System.out.println("\nSelect a number from the main menu");
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
        System.out.println("Welcome to Product Create Center.");
        System.out.println("Select new product type: " +
                "\n1. Ice Cream" +
                "\n2. Cake");

    }

    public static void read() {

    }

    public static void update() {

    }

    public static void delete() {

    }

    public static void get() {

    }

    public static void exit() {

    }

}
