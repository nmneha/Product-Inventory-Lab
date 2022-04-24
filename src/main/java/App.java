import Models.Cake;
import Models.IceCream;
import Services.CakeService;
import Services.IceCreamService;
import io.Console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private CakeService cakeService = CakeService.shared();
    private IceCreamService iceCreamService = IceCreamService.shared();
    private Console console = new Console();

    public static void main(String... args) throws IOException {
        App application = new App();
        application.init();

    }

    private void init() throws IOException {
        try {
            iceCreamService.loadData();
            cakeService.loadData();
        } catch (FileNotFoundException e) {
            try {
                iceCreamService.writeTo();
                cakeService.writeTo();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        Console.printWelcome();
        int number = 0;
        while (number != 6) {
            number = Console.printMainMenu();
//            number = getNumber("Select from the menu above");
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
                number = Console.invalidInput();
              }
        }
        try {
            iceCreamService.writeTo();
            cakeService.writeTo();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("THANK YOU FOR USING SERA 'N' DIPITY'S INVENTORY MANAGER" +
                "\nSEE YOU NEXT TIME.");
        Console.exit();
    }
}


