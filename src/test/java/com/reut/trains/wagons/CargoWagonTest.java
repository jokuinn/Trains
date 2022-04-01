package com.reut.trains.wagons;

import org.junit.Assert;
import org.junit.Test;

public class CargoWagonTest {
    @Test
    public void createCargoWagon_validData_shouldHaveAllFields() {
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();

        Assert.assertNotNull(cargoWagon.getId());
        Assert.assertNotNull(cargoWagon.getCarryingCapacity());
    }

    @Test
    public void addCargo_validData_shouldReturnTrue() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(25).build();
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();

        Assert.assertTrue(cargoWagon.addCargo(cargo));
    }

    @Test
    public void addCargo_invalidData_shouldThrowException() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(45).build();
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();

        Assert.assertThrows(IllegalArgumentException.class,
                () -> cargoWagon.addCargo(cargo));
    }

    @Test
    public void removeCargo_validData_shouldReturnTrue() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(20).build();
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();
        cargoWagon.addCargo(cargo);

        Assert.assertTrue(cargoWagon.removeCargo("1"));
    }

    @Test
    public void removeCargo_invalidData_shouldThrowException() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(20).build();
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();
        cargoWagon.addCargo(cargo);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> cargoWagon.removeCargo("2"));
    }

    @Test
    public void getCargo_validData_shouldReturnCargo() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(20).build();
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();
        cargoWagon.addCargo(cargo);

        Assert.assertEquals(cargo, cargoWagon.getCargo("1"));
    }

    @Test
    public void getCargo_invalidData_shouldThrowException() {
        Cargo cargo = Cargo.builder().id("1").name("Titan").weight(20).build();
        CargoWagon cargoWagon = CargoWagon.builder().id("1").carryingCapacity(40).build();
        cargoWagon.addCargo(cargo);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> cargoWagon.getCargo("2"));
    }
}
