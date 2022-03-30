package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CakeTest {

    Cake testCake = new Cake();

    @Test
    public void setFlavorTest() {
        String expected = "Berry Bad";
        testCake.setFlavor(expected);

        Assertions.assertEquals(expected, testCake.getFlavor());
    }

    @Test
    public void setIDTest() {
        int expected = 1234;
        testCake.setId(expected);

        Assertions.assertEquals(expected, testCake.getId());
    }

    @Test
    public void setBrandTest() {
        String brand = "Sera an' Dipity";
        testCake.setBrand(brand);

        Assertions.assertEquals(brand, testCake.getBrand());
    }

    @Test
    public void setSizeTest() {
        String size = "pint";
        testCake.setSize(size);

        Assertions.assertEquals(size, testCake.getSize());
    }

    @Test
    public void setQtyTest() {
        int qty = 20;
        testCake.setQty(qty);

        Assertions.assertEquals(qty, testCake.getQty());
    }

    @Test
    public void setPriceTest() {
        double price = 6.99;
        testCake.setPrice(price);

        Assertions.assertEquals(price, testCake.getPrice());

    }

}