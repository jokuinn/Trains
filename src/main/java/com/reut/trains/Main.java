package com.reut.trains;

import com.reut.trains.train.Train;
import com.reut.trains.wagons.*;
import com.reut.trains.users.Driver;
import com.reut.trains.users.Passenger;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        try {
            Driver driver = Driver.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Maks")
                    .lastName("Reut")
                    .age(22)
                    .driverLicense(true)
                    .build();

            Locomotive locomotive = new Locomotive(UUID.randomUUID().toString(), driver);

            log.info(locomotive.toString());

            Passenger firstPassenger = Passenger.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Lisa").lastName("Karpovich")
                    .age(22)
                    .ticket(true)
                    .ticketId(12)
                    .build();

            Passenger secondPassenger = Passenger.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Sergey").lastName("Tsalko")
                    .age(22)
                    .ticket(true)
                    .ticketId(13)
                    .build();

            Passenger thirdPassenger = Passenger.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Nikita").lastName("Reut")
                    .age(13)
                    .ticket(true)
                    .ticketId(13)
                    .build();

            PassengerWagon passengerVan = PassengerWagon.builder().capacity(30).id(UUID.randomUUID().toString()).build();
            passengerVan.addPassenger(firstPassenger);
            passengerVan.addPassenger(secondPassenger);
            passengerVan.addPassenger(thirdPassenger);

            log.info("Id: " + passengerVan.getId());

            Cargo titan = Cargo.builder().id(UUID.randomUUID().toString()).name("Titan").weight(26).build();
            Cargo gold = Cargo.builder().id(UUID.randomUUID().toString()).name("Gold").weight(15).build();
            CargoWagon cargoWagon = CargoWagon.builder().carryingCapacity(100).id(UUID.randomUUID().toString()).build();
            cargoWagon.addCargo(titan);
            cargoWagon.addCargo(gold);

            log.info("Id: " + cargoWagon.getId());
            log.info("Cargo: " + cargoWagon);

            Train train = new Train(1);
            train.addFirst(locomotive);
            train.add(cargoWagon);
            train.add(passengerVan);
            log.info("Get first wagon: \n" + train.getFirst());
            log.info("Get last wagon: \n" + train.getLast());
            log.info("Get train size: " + train.getSize());
            log.info("Get train number: " + train.getNumber());
            log.info("Check if train contains cargo wagon: " + train.contains(cargoWagon));
            log.info("Check if train is empty: " + train.isEmpty());
            train.remove(cargoWagon);
            log.info("Check size of train after remove wagon: " + train.getSize());
            train.clear();
            log.info("Check size of train after clear the train: " + train.getSize());


        } catch (IllegalArgumentException ex) {
            System.err.print("Unable to create MyClass instance: " + ex.getMessage());
        }

    }
}
