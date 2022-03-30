package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamTest {
    IceCream testIceCream = new IceCream();

    @Test
    public void setFlavorTest() {
        String expected = "Berry Bad";
        testIceCream.setFlavor(expected);

        Assertions.assertEquals(expected, testIceCream.getFlavor());
    }

   @Test
    public void setIDTest() {
        int expected = 1234;
        testIceCream.setId(expected);

        Assertions.assertEquals(expected, testIceCream.getId());
   }

   @Test
    public void setBrandTest() {
        String brand = "Sera an' Dipity";
        testIceCream.setBrand(brand);

        Assertions.assertEquals(brand, testIceCream.getBrand());
   }

   @Test
    public void setSizeTest() {
        String size = "pint";
        testIceCream.setSize(size);

        Assertions.assertEquals(size, testIceCream.getSize());
   }

   @Test
    public void setQtyTest() {
        int qty = 20;
        testIceCream.setQty(qty);

        Assertions.assertEquals(qty, testIceCream.getQty());
   }

   @Test
    public void setPriceTest() {
        double price = 6.99;
        testIceCream.setPrice(price);

        Assertions.assertEquals(price, testIceCream.getPrice());

   }


}