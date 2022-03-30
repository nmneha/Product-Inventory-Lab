package Services;

import Models.IceCream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamServiceTest {

    @Test
    public void createTest() {
        String flavor = "Bunny BonBon";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        IceCreamService service = new IceCreamService();
        IceCream bbb = service.create(brand, flavor, size, qty, price);

        int actualId = bbb.getId();
        String actualFlavor = bbb.getFlavor();;
        String actualBrand = bbb.getBrand();
        String actualSize = bbb.getSize();
        int actualQty = bbb.getQty();
        double actualPrice = bbb.getPrice();

        assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        assertEquals(brand, actualBrand);
        assertEquals(flavor, actualFlavor);
        assertEquals(size, actualSize);
        assertEquals(qty, actualQty);
        assertEquals(price, actualPrice);

        service.delete(bbb.getId());
    }

    @Test
    void findIceCream() {
        String flavor = "SugarSugar Blue";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        IceCreamService service = new IceCreamService();
        IceCream ssb =  service.create(brand, flavor, size, qty, price);

        Assertions.assertEquals(ssb, service.findIceCream(ssb.getId()));
        service.delete(ssb.getId());
    }

    @Test
    void findAll() {
        String flavor = "SugarSugar Blue";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        IceCreamService service = new IceCreamService();
        IceCream ssb =  service.create(brand, flavor, size, qty, price);
        IceCream bubbleGum = service.create(brand, "Bubble Gum", size, 15, price);

        IceCream[] expected = {ssb,  bubbleGum};

        Assertions.assertArrayEquals(expected, service.findAll());
        service.delete(ssb.getId());
        service.delete(bubbleGum.getId());

    }

    @Test
    void delete() {
        String flavor = "SugarSugar Blue";
        String brand = "Sera 'an Dipity";
        String size = "pint";
        int qty = 12;
        double price = 6.99;

        IceCreamService service = new IceCreamService();
        IceCream ssb =  service.create(brand, flavor, size, qty, price);

        Assertions.assertTrue(service.delete(ssb.getId()));
        Assertions.assertNull(service.findIceCream(ssb.getId()));


    }
}