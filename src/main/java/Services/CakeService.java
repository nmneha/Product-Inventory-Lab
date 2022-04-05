package Services;

import Models.Cake;
import Models.IceCream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeService {

    private static int nextId = 1;

    private List<Cake> inventory = new ArrayList<>();
    private static CakeService cakeService = new CakeService();


    private CakeService() {}

    public List<Cake> getInventory() {
        inventory.forEach(System.out::println);
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


}
