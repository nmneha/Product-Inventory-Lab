package io;

import Models.Cake;
import Services.CakeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    Console console = new Console();

    @Test
    void cakePrice() {
        String size12 = "12 IN ROUND";
        Assertions.assertEquals(24.99, console.cakePrice(size12));
        String size6 = "6 IN ROUND";
        Assertions.assertEquals(12.99, console.cakePrice(size6));
        String sizeInvalid = "3";
        Assertions.assertNull(console.cakePrice(sizeInvalid));
    }
}