package com.reut.trains.wagons;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Wagon {
    @NonNull
    protected final String id;

    public Wagon(@NonNull String id) {
        this.id = id;
    }
}
