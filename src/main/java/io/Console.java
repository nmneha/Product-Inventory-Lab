package io;

import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {
    private static final Scanner userInput = new Scanner(System.in);
    static IceCreamService iceCreamService = IceCreamService.shared();
    static CakeService cakeService = CakeService.shared();

    public static int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\"" + userInput.nextLine() + "\" isn't a number!");
            }
        }
    }


    //this may not work TODO - make sure you add a condition to catch invalid strings
    public static String getString(String message) {
        System.out.println(message);
        return userInput.nextLine();

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

    public static void printProdChoice() {
        System.out.println("Select the product you would like to edit: " +
                "\n1. Ice Cream" +
                "\n2. Cake");
    }

    public static int create() {
        System.out.print("Welcome to Product Create Center"+
                "\nSelect new product type: " +
                "\n1. Ice Cream" +
                "\n2. Cake");
        return getNumber("\nENTER 1 OR 2");
    }

    public void createIceCream() {
        userInput.nextLine();
        String brand = getString("Enter the brand");
        String flavor = getString("What flavor is it?");
        String size = getString("Enter a size.");
        int qty = -1;
        while (qty < 0) {
            qty = getNumber("How much inventory is there?");
        }
        double price = -1.0;
        while (price < 0.0) {
            price = getDouble("What is the price?");
        }
//        iceCreamService.createIceCream(getString("Enter the brand"),
//                getString("What flavor is it?"),
//                getString("Enter a size."),
//                getNumber("How much inventory is there?"),
//                getDouble("What is the price?"));
        iceCreamService.createIceCream(brand, flavor, size, qty, price);

    }


    public void createCake() {
        userInput.nextLine();
        String flavor = getString("What flavor is the cake?");
        String size = getString("Select from one of the options below:" +
                "\n[12 IN ROUND]" +
                "\n[6 IN ROUND]");
//        while (!size.equals("12 IN ROUND") && !size.equals("6 IN ROUND")) {
//            size = getString("Select from one of the options below:" +
//                    "\n[12 IN ROUND]" +
//                    "\n[6 IN ROUND]");
//        }
        int qty = getNumber("How much inventory is there?");
        double price = cakePrice(size);

        cakeService.create(flavor, size, qty, price);

    }

    public static int read() {
        System.out.println("Welcome to Inventory Reader" +
                "\nWhich inventory would you like to look at?:" +
                "\n1. Ice Cream" +
                "\n2. Cake");
        return getNumber("ENTER 1 OR 2");
    }

    public void readIceCream() {
        System.out.println("\n-------------------------------\n");
        IceCream[] array = iceCreamService.findAllIceCream();
        if (array.length != 0) {
            for (IceCream ic : array) {
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
            for (Cake c : array) {
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
        String confirm;
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
            }
            choice = getNumber("Enter 0 to exit or enter a different ID number to delete.");
        }
    }

    public void deleteCake() {
        currentInventory("Cake");
        String confirm;
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
            }
            choice = getNumber("Enter 0 to exit or enter a different ID number to delete.");
        }
    }

    public int get() {
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

    public void getIceCream() {
        String brand = "";
        String flavor;
        IceCream[] arr = iceCreamService.findAllIceCream();
        List<IceCream> list = iceCreamService.getInventory();
        System.out.println("List of all current items.");
        for (IceCream iceCream : arr) {
            System.out.println("BRAND: " + iceCream.getBrand() +
                    "\nFLAVOR: " + iceCream.getFlavor());
        }
        while (!brand.equals("exit")) {
            brand = getString("Enter the brand of the item you want to look at" +
                    "\nor enter 'exit' to leave the station.");
            flavor = getString("Enter the flavor of the item.");
            for (IceCream ic : list) {
                if (ic.getBrand().equals(brand) && ic.getFlavor().equals(flavor)) {
                    System.out.println(iceCreamService.printIceCream(ic));
                } else {
                    System.out.println("That item does not exist.");
                }
            }
        }
    }

    public void getCake() {
        String brand = "";
        String flavor;
        Cake[] arr = cakeService.findAll();
        List<Cake> list = cakeService.getInventory();
        System.out.println("List of all current items.");
        for (Cake cake : arr) {
            System.out.println("BRAND: " + cake.getBrand() +
                    "\nFLAVOR: " + cake.getFlavor());
            System.out.println("\n-------------------------------");
        }
        while (!brand.equals("exit")) {
            brand = getString("Enter the brand of the item you want to look at" +
                    "\nor enter 'exit' to leave the station.");
            flavor = getString("Enter the flavor of the item.");
            for (Cake c : list) {
                if (c.getBrand().equals(brand) && c.getFlavor().equals(flavor)) {
                    System.out.println(cakeService.printCake(c));
                } else {
                    System.out.println("That item does not exist.");
                }
            }
        }
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
