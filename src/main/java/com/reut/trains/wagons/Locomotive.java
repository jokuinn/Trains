package com.reut.trains.wagons;

import com.reut.trains.users.Driver;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Locomotive extends Wagon {

    @NonNull
    Driver driver;

    public Locomotive(@NonNull String id, @NonNull Driver driver) {
        super(id);
        this.driver = driver;

        log.info("Locomotive has been created!");
    }

    @Override
    public String toString() {
        return "Locomotive: " +
                "id: " + id +
                "Driver: " + driver;
    }

}
