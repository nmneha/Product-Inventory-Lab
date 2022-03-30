package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamTest {


    @Test
    public void setNaeTest() {
        String expected = "Berry Bad";

        IceCream testIceCream = new IceCream();
        testIceCream.setName(expected);

        Assertions.assertEquals(expected, testIceCream.getName());
    }
}