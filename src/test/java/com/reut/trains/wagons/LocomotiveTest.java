package com.reut.trains.wagons;

import com.reut.trains.users.Driver;
import org.junit.Assert;
import org.junit.Test;

public class LocomotiveTest {

    @Test
    public void createLocomotive_validData_shouldHaveAllFields() {
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();

        Locomotive locomotive = new Locomotive("1", driver);

        Assert.assertNotNull(locomotive.getId());
        Assert.assertNotNull(locomotive.getDriver());
    }

}
