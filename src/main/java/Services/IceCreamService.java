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
import java.util.Map;

public class IceCreamService {

    private static int nextId = 1;
    private List<IceCream> inventory = new ArrayList<>();
    private static IceCreamService iceCreamService = new IceCreamService();

    private IceCreamService() {}

    public static IceCreamService shared() {
        return iceCreamService;
    }


    public IceCream createIceCream(String brand, String flavor, String size, int qty, double price) {
        IceCream createdIceCream = new IceCream(nextId++, brand, flavor, size, qty, price);
        inventory.add(createdIceCream);

        return createdIceCream;
    }

    //read
    public IceCream findIceCream(int id) {
        for (IceCream ic : inventory) {
            if (ic.getId() == id) {
                return ic;
            }
        }
        return null;
        // should take an int and return an object with that id, if exists
    }

    //read all
    public IceCream[] findAllIceCream() {
        // should return a basic array copy of the ArrayList
        IceCream[] array = new IceCream[inventory.size()];
        for (int i = 0; i < array.length; i++) {
                array[i] = inventory.get(i);
            }
        return array;
    }

    //delete
    public boolean deleteIceCream(int id) {
        if (findIceCream(id) != null) {
            inventory.remove(findIceCream(id));
            return true;
        }
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        return false;
    }

    public String printIceCream(IceCream ic) {
        String iceCream = "Id: " + ic.getId() +
                "\nBrand: " + ic.getBrand() +
                "\nFlavor: " + ic.getFlavor() +
                "\nSize: " + ic.getSize() +
                "\nQty: " + ic.getQty() +
                "\nPrice: " + ic.getPrice() +
                "\n\n-------------------------------";
        return iceCream;
    }

    public String printAllIceCream() {
        IceCream[] iceCream = findAllIceCream();
        String iceCreamInventory = "";
        for (int i = 0; i < iceCream.length; i++) {
            if (i == iceCream.length-1) {
                iceCreamInventory += printIceCream(iceCream[i]);
            } else {
                iceCreamInventory += printIceCream(iceCream[i]) + "\n";
            }
        }
        return iceCreamInventory;
    }

    public List<IceCream> getInventory() {
        return inventory;
    }

    public void writeTo() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("icecream.json"), inventory);
//        String csvFile = "/Users/nusera/Development/Product-Inventory-Lab/src/main/java/Services/IceCream.csv";
//        FileWriter writer = new FileWriter(csvFile); //(1)
//
//        CVSUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));  // (2)
//
//        for (IceCream ic : inventory) {
//            List<String> list = new ArrayList<>(); // (3)
//            list.add(String.valueOf(ic.getId()));
//            list.add(ic.getBrand());
//            list.add(ic.getFlavor());
//            list.add(ic.getSize());
//            list.add(String.valueOf(ic.getQty()));
//            list.add(String.valueOf(ic.getPrice()));
//
//            CVSUtils.writeLine(writer, list);  // (4)
//        }
//
//// (5)
//        writer.flush();
//        writer.close();
    }

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("icecream.json"), new TypeReference<List<IceCream>>(){});
//        // (1)
//        String csvFile = "/Users/nusera/Development/Product-Inventory-Lab/src/main/java/Services/IceCream.csv";
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
//                inventory.add(new IceCream(id, brand, flavor, size, qty, price));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
