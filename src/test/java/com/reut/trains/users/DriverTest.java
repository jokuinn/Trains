package com.reut.trains.users;

import org.junit.Assert;
import org.junit.Test;

public class DriverTest {

    @Test
    public void createDriver_validData_shouldHaveAllFields() {
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();

        Assert.assertNotNull(driver.getId());
        Assert.assertNotNull(driver.getName());
        Assert.assertNotNull(driver.getLastName());
        Assert.assertNotNull(driver.getAge());
        Assert.assertNotNull(driver.getDriverLicense());
    }

    @Test
    public void createDriver_withoutLicense_shouldThrowException() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(false).build());
    }

    @Test
    public void createDriver_invalidAgeData_shouldThrowException() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Driver.builder().id("1").name("Maks").lastName("Reut").age(17).driverLicense(true).build());
    }
}
