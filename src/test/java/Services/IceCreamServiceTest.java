package Services;

import Models.IceCream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamServiceTest {

    @Test
    public void createTest() {
        int id = 1;
        String flavor = "Bunny BonBon";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        IceCreamService bbbSer = new IceCreamService();
        IceCream bbb = bbbSer.create(brand, flavor, size, qty, price);

        int actualId = bbb.getId();
        String actualFlavor = bbb.getFlavor();;
        String actualBrand = bbb.getBrand();
        String actualSize = bbb.getSize();
        int actualQty = bbb.getQty();
        double actualPrice = bbb.getPrice();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(id, actualId);
        Assertions.assertEquals(brand, actualBrand);
        Assertions.assertEquals(flavor, actualFlavor);
        Assertions.assertEquals(size, actualSize);
        Assertions.assertEquals(qty, actualQty);
        Assertions.assertEquals(price, actualPrice);

    }

    @Test
    void findIceCream() {
        String flavor = "SugarSugar Blue";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        IceCreamService ssbSer = new IceCreamService();
        IceCream ssb =  ssbSer.create(brand, flavor, size, qty, price);

        int actualId = ssb.getId();

        Assertions.assertEquals(ssb, ssbSer.findIceCream(ssb.getId()));
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}