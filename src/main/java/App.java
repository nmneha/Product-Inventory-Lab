import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;
import io.Console;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private CakeService cakeService = CakeService.shared();
    private IceCreamService iceCreamService = IceCreamService.shared();
    private Console console = new Console();

    private static Scanner userInput = new Scanner(System.in);

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

    public static void main(String... args) throws IOException {
        App application = new App();
        application.init();

    }

    private void init() throws IOException {
        iceCreamService.loadData();
        cakeService.loadData();
        Console.printWelcome();
        int number = 0;
        while (number != 6) {
            Console.printMainMenu();
            number = getNumber("Select from the menu above");
            if (number == 1) {
                int productType = console.create();
                if (productType == 1) {
                    console.createIceCream();
                } else if (productType == 2) {
                    console.createCake();
                }
            } else if (number == 2) {
                int inventoryNum = Console.read();
                if (inventoryNum == 1) {
                    console.readIceCream();
                } else if (inventoryNum == 2) {
                    console.readCake();
                }
            } else if (number == 3) {
                int choice = console.update();
                if (choice == 1) {
                    console.updateIceCream();
                } else {
                    console.updateCake();
                }
            } else if (number == 4) {
                int choice = Console.delete();
                if (choice == 1) {
                    console.deleteIceCream();
                } else {
                    console.deleteCake();
                }
            } else if (number == 5) {
                int choice = console.get();
                if (choice == 1) {
                    console.getIceCream();
                } else {
                    console.getCake();
                }
            } else if (number > 6 || number < 1) {
                getNumber("This is not a valid input." +
                        "\nPlease pick a number from the menu above or enter 6 to exit.");
            }
        }
        iceCreamService.writeTo();
        cakeService.writeTo();
        System.out.println("THANK YOU FOR USING SERA 'N' DIPITY'S INVENTORY MANAGER" +
                "\nSEE YOU NEXT TIME.");
    }


    private void switchTest() throws IOException {
//        iceCreamService.loadData();
//        cakeService.loadData();
        Console.printWelcome();
        int number = 0;
        while (number != 6) {
            Console.printProdChoice();
            number = getNumber("Select from the menu above");
            switch (number) {
                case 1:
                    Console.printMainMenu();
                    int edit = getNumber("Select from the menu above.");
                    switch (edit) {
                        case 1:
                            console.createIceCream();
                        case 2:
                            console.readIceCream();
                        case 3:
                            console.updateIceCream();
                        case 4:
                            console.deleteIceCream();
                        case 5:
                            console.getIceCream();
                        case 6:
                            break;
                    }
                case 2:
                    Console.printMainMenu();
                    edit = getNumber("Select from the menu above.");
                    switch (edit) {
                        case 1:
                            console.createIceCream();
                        case 2:
                            console.readIceCream();
                        case 3:
                            console.updateIceCream();
                        case 4:
                            console.deleteIceCream();
                        case 5:
                            console.getIceCream();
                        case 6:
                            break;
                    }
            }
        }
        System.out.println("THANK YOU FOR USING SERA 'N' DIPITY'S INVENTORY MANAGER" +
                "\nSEE YOU NEXT TIME.");
    }
}


