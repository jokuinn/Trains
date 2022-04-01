package com.reut.trains.wagons;

import com.reut.trains.users.Passenger;
import org.junit.Assert;
import org.junit.Test;

public class PassengerWagonTest {

    @Test
    public void createPassengerWagon_validData_shouldHaveAllFields() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        Assert.assertNotNull(passengerWagon.getId());
        Assert.assertNotNull(passengerWagon.getCapacity());
        Assert.assertNotNull(passengerWagon.getPassengers());
        Assert.assertNotNull(passengerWagon.getPassenger(1));

    }

    @Test
    public void addPassenger_validData_shouldReturnTrue() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();

        Assert.assertTrue(passengerWagon.addPassenger(passenger));
    }

    @Test
    public void addPassenger_invalidData_shouldThrowException() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(26).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();

        Assert.assertThrows(IllegalArgumentException.class,
                () -> passengerWagon.addPassenger(passenger));
    }

    @Test
    public void removePassenger_validData_shouldReturnTrue() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        Assert.assertTrue(passengerWagon.removePassenger(1));
    }

    @Test
    public void removePassenger_invalidData_shouldThrowException() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> passengerWagon.removePassenger(2));
    }

    @Test
    public void getPassenger_validData_shouldReturnPassenger() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        Assert.assertEquals(passenger, passengerWagon.getPassenger(1));
    }

    @Test
    public void getPassenger_invalidData_shouldThrowException() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> passengerWagon.getPassenger(2));
    }

}
