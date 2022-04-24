package Services;

import Models.Cake;
import Models.IceCream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import utils.CVSUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CakeService {

    private static int nextId = 1;

    private List<Cake> inventory = new ArrayList<>();
    private static CakeService cakeService = new CakeService();


    private CakeService() {}

    public List<Cake> getInventory() {
        return inventory;
    }

    public static CakeService shared() {
        return cakeService;
    }

    public Cake create(String flavor, String size, int qty, double price) {
        Cake createdCake = new Cake(nextId++, flavor, size, qty, price);
        inventory.add(createdCake);

        return createdCake;
    }

    //read
    public Cake findCake(int id) {
        for (Cake c : inventory) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Cake[] findAll() {
        // should return a basic array copy of the ArrayList
        Cake[] array = new Cake[inventory.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = inventory.get(i);
        }
        return array;
    }

    //delete
    public boolean delete(int id) {
        if (findCake(id) != null) {
            inventory.remove(findCake(id));
            return true;
        }
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        return false;
    }

    public String printCake(Cake c) {
        String cake = "Id: " + c.getId() +
                "\nFlavor: " + c.getFlavor() +
                "\nSize: " + c.getSize() +
                "\nQty: " + c.getQty() +
                "\nPrice: " + c.getPrice() +
                "\n\n-------------------------------";
        return cake;
    }

    public String printAllCake() {
        Cake[] cake = findAll();
        String cakeInventory = "";
        for (int i = 0; i < cake.length; i++) {
            if (i == cake.length-1) {
                cakeInventory += printCake(cake[i]);
            } else {
                cakeInventory += printCake(cake[i]) + "\n";
            }
        }
        return cakeInventory;
    }

    public void writeTo() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("cake.json"), inventory);
//        String csvFile = "/Users/nusera/Development/Product-Inventory-Lab/src/main/java/Services/Cake.csv";
//        FileWriter writer = new FileWriter(csvFile); //(1)
//
//        CVSUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));  // (2)
//
//        for (Cake c : inventory) {
//            List<String> list = new ArrayList<>(); // (3)
//            list.add(String.valueOf(c.getId()));
//            list.add(c.getBrand());
//            list.add(c.getFlavor());
//            list.add(c.getSize());
//            list.add(String.valueOf(c.getQty()));
//            list.add(String.valueOf(c.getPrice()));
//
////            CVSUtils.writeLine(writer, list);  // (4)
//        }
//
//// (5)
//        writer.flush();
//        writer.close();
    }

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("cake.json"), new TypeReference<List<Cake>>(){});
//        // (1)
//        String csvFile = "/Users/nusera/Development/Product-Inventory-Lab/src/main/java/Services/Cake.csv";
//        String line = "";
//        String csvSplitBy = ",";
//
//        // (2)
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            nextId = Integer.parseInt(br.readLine());  // (3)
//
//            while ((line = br.readLine()) != null) {
//                // split line with comma
//                String[] beer = line.split(csvSplitBy);
//
//                // (4)
//                int id = Integer.parseInt(beer[0]);
//                String brand = beer[1];
//                String flavor = beer[2];
//                String size = beer[3];
//                int qty = Integer.parseInt(beer[4]);
//                double price = Double.parseDouble(beer[5]);
//
//                // (5)
//                inventory.add(new Cake(id, flavor, size, qty, price));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
