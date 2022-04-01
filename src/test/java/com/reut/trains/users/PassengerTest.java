package com.reut.trains.users;

import org.junit.Assert;
import org.junit.Test;

public class PassengerTest {

    @Test
    public void createPassenger_validData_shouldHaveAllFields() {
        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();

        Assert.assertNotNull(passenger.getId());
        Assert.assertNotNull(passenger.getName());
        Assert.assertNotNull(passenger.getLastName());
        Assert.assertNotNull(passenger.getAge());
        Assert.assertNotNull(passenger.getTicketId());
    }

    @Test
    public void createPassenger_withoutTicket_shouldThrowException() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(false).ticketId(1).build());
    }
}
