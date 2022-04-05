package Services;

import Models.Cake;
import Models.IceCream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CakeServiceTest {

    @Test
    public void createTest() {
        int id = 1;
        String flavor = "Strawberry Shorts";
        String brand = "Sera 'an Dipity";
        String size = "12 in round";
        int qty = 12;
        double price = 19.99;

        CakeService service = new CakeService();
        Cake ss = service.createCake(brand, flavor, size, qty, price);

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

        service.deleteCake(ss.getId());
    }

    @Test
    void findCake() {
        String flavor = "Choco Choc";
        String brand = "Sera 'an Dipity";
        String size = "12 in round";
        int qty = 12;
        double price = 19.99;

        CakeService service = new CakeService();
        Cake cc =  service.createCake(brand, flavor, size, qty, price);

        Assertions.assertEquals(cc, service.findCake(cc.getId()));
        service.deleteCake(cc.getId());
    }

    @Test
    void findAllTest() {
        String flavor = "Salted Stacks";
        String brand = "Sera 'an Dipity";
        String size = "6 in round";
        int qty = 12;
        double price = 15.99;

        CakeService service = new CakeService();
        Cake saltedstacks =  service.createCake(brand, flavor, size, qty, price);
        Cake birthday_bash = service.createCake(brand, "Birthday Bash", size, 10, price);

        Cake[] expected = {saltedstacks, birthday_bash};

        Assertions.assertArrayEquals(expected, service.findAllCake());
        service.deleteCake(saltedstacks.getId());
        service.deleteCake(birthday_bash.getId());

    }

    @Test
    void delete() {
        String flavor = "SugarSugar Blue";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        CakeService service = new CakeService();
        Cake ssb =  service.createCake(brand, flavor, size, qty, price);

        Assertions.assertTrue(service.deleteCake(ssb.getId()));
        Assertions.assertNull(service.findCake(ssb.getId()));

    }
}