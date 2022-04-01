package com.reut.trains.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Passenger extends User {

    private boolean ticket;

    private Integer ticketId;

    @Builder(toBuilder = true)
    public Passenger(@NonNull String id, @NonNull String name, @NonNull String lastName, @NonNull int age, boolean ticket, Integer ticketId) {
        super(id, name, lastName, age);
        this.ticket = ticket;
        if (ticket) {
            this.ticketId = ticketId;
        } else {
            throw new IllegalArgumentException("Passenger must have a ticket!");
        }

        log.info("Passenger has been created!");
    }

}
