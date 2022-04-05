import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;
import io.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private CakeService cakeService = CakeService.shared();
    private IceCreamService iceCreamService = new IceCreamService();
    Console console = new Console();

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

    public static void main(String... args){
        App application = new App();
        application.init();

    }

    private void init() {
        console.printWelcome();
        console.printMainMenu();
        int number = 0;
        while (number != 6 ) {
            number = getNumber("Select from the menu above");
            console.selectMenu(number);
            if (number == 1) {
                console.create();
                int productType = getNumber("ENTER 1 OR 2");
                if (productType == 1) {
                    createIceCream();
                } else if (productType == 2) {
                    createCake();
                }
            } else if (number == 2) {
                console.read();
                int inventoryNum = getNumber("ENTER 1 OR 2");
                if (inventoryNum == 1) {
                   readIceCream();
                } else if (inventoryNum == 2) {
                    readCake();
                }

            } else if (number == 3) {

            } else if (number == 4) {

            } else if (number == 5) {

            } else if (number > 6 || number < 6) {
                getNumber("This is not a valid input." +
                        "\nPlease pick a number from the menu above or enter 6 to exit.");
            }
        }
    }

    private void createCake() {
        console.cakeFlavor();
        String flavor = userInput.next();
        console.cakeSize();
        String size = userInput.next();
        while (size != "12 IN ROUND" || size != "6 IN ROUND") {
            System.out.println("This is not a valid input." +
                    "Please enter a size from above.");
            size = userInput.next();
        }
        int qty = getNumber("How much inventory is there?");
        double price = console.cakePrice(size);
        cakeService.create(flavor, size, qty, price);
    }

    private void createIceCream() {
        console.iceCreamBrand();
        String brand = userInput.next();
        console.iceCreamFlavor();
        String flavor = userInput.next();
        console.iceCreamSize();
        String size = userInput.next();
        int qty = getNumber("How much inventory is there?");
        System.out.println("What is the price?");
        double price = userInput.nextInt();
        iceCreamService.createIceCream(brand, flavor, size, qty, price);
    }

    public void readIceCream() {
        IceCream[] array = iceCreamService.findAllIceCream();
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
            IceCream ic = array[i];
            System.out.println("Id: " + ic.getId() +
                    "\nBrand: " + ic.getBrand() +
                    "\nFlavor: " + ic.getFlavor() +
                    "\nSize: " + ic.getSize() +
                    "\nQty: " + ic.getQty() +
                    "\nPrice: " + ic.getPrice() +
                    "\n\n-------------------------------");
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
                System.out.println("Id: " + c.getId() +
                        "\nFlavor: " + c.getFlavor() +
                        "\nSize: " + c.getSize() +
                        "\nQty: " + c.getQty() +
                        "\nPrice: " + c.getPrice() +
                        "\n\n-------------------------------");
            }
        } else {
            System.out.println("There is no inventory for this product.");
        }
    }
}


