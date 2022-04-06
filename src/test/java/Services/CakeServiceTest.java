package Services;

import Models.Cake;
import Models.IceCream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CakeServiceTest {

    CakeService service = CakeService.shared();
    List<Cake> inventory = service.getInventory();

    @Test
    public void createTest() {
        String flavor = "Strawberry Shorts";
        String brand = "Sera 'N' Dipity";
        String size = "12 in round";
        int qty = 12;
        double price = 19.99;

        Cake ss = service.create(flavor, size, qty, price);

        int actualId = ss.getId();
        String actualFlavor = ss.getFlavor();;
        String actualBrand = ss.getBrand();
        String actualSize = ss.getSize();
        int actualQty = ss.getQty();
        double actualPrice = ss.getPrice();

        assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        assertEquals(brand, actualBrand);
        assertEquals(flavor, actualFlavor);
        assertEquals(size, actualSize);
        assertEquals(qty, actualQty);
        assertEquals(price, actualPrice);

        service.delete(ss.getId());
    }

    @Test
    void findCake() {
        String flavor = "Choco Choc";
        String size = "12 in round";
        int qty = 12;
        double price = 19.99;

        Cake cc =  service.create(flavor, size, qty, price);

        Assertions.assertEquals(cc, service.findCake(cc.getId()));
        service.delete(cc.getId());
    }

    @Test
    void findAllTest() {
        String flavor = "Salted Stacks";
        String size = "6 in round";
        int qty = 12;
        double price = 15.99;

        Cake saltedstacks =  service.create(flavor, size, qty, price);
        Cake birthday_bash = service.create("Birthday Bash", size, 10, price);

        Cake[] expected = {saltedstacks, birthday_bash};

        Assertions.assertArrayEquals(expected, service.findAll(inventory));
        service.delete(saltedstacks.getId());
        service.delete(birthday_bash.getId());

    }

    @Test
    void delete() {
        String flavor = "SugarSugar Blue";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        Cake ssb =  service.create(flavor, size, qty, price);

        Assertions.assertTrue(service.delete(ssb.getId()));
        Assertions.assertNull(service.findCake(ssb.getId()));

    }
}