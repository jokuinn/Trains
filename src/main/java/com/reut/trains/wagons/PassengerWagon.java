package com.reut.trains.wagons;

import com.reut.trains.users.Passenger;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class PassengerWagon extends Wagon {
    public static final Integer MIN_CAPACITY = 0;
    public static final Integer MAX_CAPACITY = 30;

    private List<Passenger> passengers;

    @NonNull
    private Integer capacity;

    @Builder(toBuilder = true)
    protected PassengerWagon(@NonNull String id, int capacity) {
        super(id);
        if (MIN_CAPACITY < capacity && capacity <= MAX_CAPACITY) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Passenger capacity from 0 to 30!");
        }
        passengers = new ArrayList<>(capacity);

        log.info("Passenger van has been created!");
    }

    public boolean addPassenger(Passenger passenger) {
        if (passenger != null && passenger.isTicket() && passenger.getTicketId() < capacity) {
            passengers.add(passenger);
            log.info("Passenger has been added into the wagon!");
            return true;
        } else {
            throw new IllegalArgumentException("Passenger must have a ticket for this wagon!");
        }
    }

    public boolean removePassenger(int ticketId) {
        for (Passenger passenger: passengers) {
            if (passenger.getTicketId() == ticketId) {
                passengers.remove(passenger);
                log.info("Passenger has been removed!");
                return true;
            }
        }
        throw new IllegalArgumentException("Passenger not found!");
    }

    public Passenger getPassenger(int ticketId) {
        for (Passenger passenger: passengers) {
            if (passenger.getTicketId() == ticketId) {
                log.info("Passenger has been found");
                return passenger;
            }
        }
        throw new IllegalArgumentException("Passenger not found!");
    }

    @Override
    public String toString() {
        return "Passenger wagon: " +
                "id: " + id + "\n" +
                "Passengers: " + passengers;
    }
}
