package com.reut.trains.wagons;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Cargo {

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private Integer weight;

    @Builder(toBuilder = true)
    public Cargo(String id, String name, Integer weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;

        log.info("Cargo has been created!");
    }

    @Override
    public String toString() {
        return "Cargo: " +
                "id: " + id + ", " +
                "name: " + name +
                ", weight: " + weight + "\n";
    }
}
