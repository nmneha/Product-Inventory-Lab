package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamTest {

    @Test
    public void constructorTest() {
        int id = 123;
        String flavor = "Choco Storm";
        String brand = "Sera an' Dipity";
        String size = "pint";
        int qty = 15;
        double price = 6.99;

        IceCream chocoStorm = new IceCream(id, brand, flavor, size, qty, price);

        Assertions.assertEquals(id, chocoStorm.getId());
        Assertions.assertEquals(flavor, chocoStorm.getFlavor());
        Assertions.assertEquals(brand, chocoStorm.getBrand());
        Assertions.assertEquals(size, chocoStorm.getSize());
        Assertions.assertEquals(price, chocoStorm.getPrice());
    }

    @Test
    public void setFlavorTest() {
        IceCream testIceCream = new IceCream();
        String expected = "Berry Bad";
        testIceCream.setFlavor(expected);

        Assertions.assertEquals(expected, testIceCream.getFlavor());
    }

   @Test
    public void setIDTest() {
        IceCream testIceCream = new IceCream();
        int expected = 1234;
        testIceCream.setId(expected);

        Assertions.assertEquals(expected, testIceCream.getId());
   }

   @Test
    public void setBrandTest() {
       IceCream testIceCream = new IceCream();
        String brand = "Sera an' Dipity";
        testIceCream.setBrand(brand);

        Assertions.assertEquals(brand, testIceCream.getBrand());
   }

   @Test
    public void setSizeTest() {
        IceCream testIceCream = new IceCream();
        String size = "pint";
        testIceCream.setSize(size);

        Assertions.assertEquals(size, testIceCream.getSize());
   }

   @Test
    public void setQtyTest() {
        IceCream testIceCream = new IceCream();
        int qty = 20;
        testIceCream.setQty(qty);

        Assertions.assertEquals(qty, testIceCream.getQty());
   }

   @Test
    public void setPriceTest() {
        IceCream testIceCream = new IceCream();
        double price = 6.99;
        testIceCream.setPrice(price);

        Assertions.assertEquals(price, testIceCream.getPrice());

   }


}