import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;
import io.Console;

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

    public static void main(String... args){
        App application = new App();
        application.init();

    }

    private void init() {
        Console.printWelcome();
        int number = 0;
        while (number != 6 ) {
            Console.printMainMenu();
            number = getNumber("Select from the menu above");
            if (number == 1) {
                Console.create();
                int productType = getNumber("ENTER 1 OR 2");
                if (productType == 1) {
                    console.createIceCream();
                } else if (productType == 2) {
                    console.createCake();
                }
            } else if (number == 2) {
                Console.read();
                int inventoryNum = getNumber("ENTER 1 OR 2");
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

            } else if (number == 5) {

            } else if (number > 6 || number < 1) {
                getNumber("This is not a valid input." +
                        "\nPlease pick a number from the menu above or enter 6 to exit.");
            }
        }
    }

}


