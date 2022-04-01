package com.reut.trains.wagons;

import org.junit.Assert;
import org.junit.Test;

public class CargoTest {
    @Test
    public void createCargo_validData_shouldHaveAllFields() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(25).build();

        Assert.assertNotNull(cargo.getId());
        Assert.assertNotNull(cargo.getName());
        Assert.assertNotNull(cargo.getWeight());
    }
}
