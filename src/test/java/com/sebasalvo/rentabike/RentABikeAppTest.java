package com.sebasalvo.rentabike;

import com.sebasalvo.rentabike.controller.HomeController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentABikeAppTest {

    @Test
    public void testApp() {

        HomeController homeController = new HomeController();
        String result = homeController.home();
        assertEquals(result, "Rent-a-Bike dummy home page :)");

    }

}
