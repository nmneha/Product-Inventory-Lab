package Services;

import Models.IceCream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IceCreamService {

    private static int nextId = 1;
    private List<IceCream> inventory = new ArrayList<>();


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

    public void printIceCream(IceCream ic) {
        System.out.println("Id: " + ic.getId() +
                "\nBrand: " + ic.getBrand() +
                "\nFlavor: " + ic.getFlavor() +
                "\nSize: " + ic.getSize() +
                "\nQty: " + ic.getQty() +
                "\nPrice: " + ic.getPrice() +
                "\n\n-------------------------------");
    }

}
