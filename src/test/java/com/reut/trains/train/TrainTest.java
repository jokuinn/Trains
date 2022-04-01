package com.reut.trains.train;

import com.reut.trains.users.Driver;
import com.reut.trains.users.Passenger;
import com.reut.trains.wagons.Locomotive;
import com.reut.trains.wagons.PassengerWagon;
import org.junit.Assert;
import org.junit.Test;

public class TrainTest {
    @Test
    public void createTrain_validData_shouldHaveAllFields() {
        Train train = new Train(1);

        Assert.assertNotNull(train.getNumber());
        Assert.assertTrue(train.isEmpty());
    }

    @Test
    public void createTrain_invalidData_shouldThrowException() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> new Train(0));
    }

    @Test
    public void add_shouldAddWagon() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Assert.assertTrue(train.add(locomotive));
    }

    @Test
    public void addFirst_shouldAddWagon() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Assert.assertTrue(train.addFirst(locomotive));
    }

    @Test
    public void contains_validData_shouldReturnTrue() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        train.add(locomotive);

        Assert.assertTrue(train.contains(locomotive));
    }

    @Test
    public void contains_invalidData_shouldReturnFalse() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        train.add(locomotive);

        Assert.assertFalse(train.contains(passengerWagon));
    }

    @Test
    public void isEmpty_shouldReturnFalseIfTrainNotEmpty() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        train.add(locomotive);

        Assert.assertFalse(train.isEmpty());
    }

    @Test
    public void isEmpty_shouldReturnTrueIfTrainIsEmpty() {
        Train train = new Train(1);

        Assert.assertTrue(train.isEmpty());
    }

    @Test
    public void remove_shouldReturnTrueIfWagonWasRemoved() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        train.add(locomotive);

        Assert.assertTrue(train.remove(locomotive));
    }

    @Test
    public void remove_shouldReturnFalseIfWagonWasNotRemoved() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Assert.assertFalse(train.remove(locomotive));
    }

    @Test
    public void clear_trainShouldBeEmptyAfterClearing() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        train.add(locomotive);
        train.clear();

        Assert.assertTrue(train.isEmpty());
    }

    @Test
    public void getFirst_shouldReturnFirstWagon() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        train.add(locomotive);
        train.add(passengerWagon);

        Assert.assertEquals(locomotive, train.getFirst());
    }

    @Test
    public void getLast_shouldReturnLastWagon() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        train.add(locomotive);
        train.add(passengerWagon);

        Assert.assertEquals(passengerWagon, train.getLast());
    }

    @Test
    public void getSize_shouldReturnTrainSize() {
        Train train = new Train(1);
        Driver driver = Driver.builder().id("1").name("Maks").lastName("Reut").age(22).driverLicense(true).build();
        Locomotive locomotive = new Locomotive("1", driver);

        Passenger passenger = Passenger.builder().id("1").name("Maks").lastName("Reut").age(18).ticket(true).ticketId(1).build();
        PassengerWagon passengerWagon = PassengerWagon.builder().capacity(25).id("1").build();
        passengerWagon.addPassenger(passenger);

        train.add(locomotive);
        train.add(passengerWagon);

        Integer expected = 2;
        Integer actual = train.getSize();

        Assert.assertEquals(expected, actual);
    }
}
