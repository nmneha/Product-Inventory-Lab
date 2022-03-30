package Services;

import Models.IceCream;

import java.util.ArrayList;
import java.util.List;

public class IceCreamService {

    private static int nextId = 1;
    private List<IceCream> inventory = new ArrayList<>();


    public IceCream create(String brand, String flavor, String size, int qty, double price) {
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
    public IceCream[] findAll() {
        // should return a basic array copy of the ArrayList
        return null;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        return false;
    }


}
