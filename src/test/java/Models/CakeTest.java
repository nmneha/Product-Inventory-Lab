package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CakeTest {

    Cake testCake = new Cake();

    @Test
    public void constructorTest() {
        int id = 123;
        String flavor = "Red Velvety";
        String brand = "Sera an' Dipity";
        String size = "12 inch round";
        int qty = 15;
        double price = 6.99;

        Cake redVelvet = new Cake(id, brand, flavor, size, qty, price);

        Assertions.assertEquals(id, redVelvet.getId());
        Assertions.assertEquals(flavor, redVelvet.getFlavor());
        Assertions.assertEquals(brand, redVelvet.getBrand());
        Assertions.assertEquals(size, redVelvet.getSize());
        Assertions.assertEquals(price, redVelvet.getPrice());
    }

    @Test
    public void setFlavorTest() {
        String expected = "Raspberry Chocolate";
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
        String size = "12 inch round";
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