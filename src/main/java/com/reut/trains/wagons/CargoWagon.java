package com.reut.trains.wagons;

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
public class CargoWagon extends Wagon {

    @NonNull
    private Integer carryingCapacity;

    @NonNull
    private Integer freeSpace;

    private List<Cargo> cargos;

    @Builder(toBuilder = true)
    protected CargoWagon(@NonNull String id, int carryingCapacity) {
        super(id);
        this.freeSpace = carryingCapacity;
        this.carryingCapacity = carryingCapacity;
        cargos = new ArrayList<>();
    }

    public boolean addCargo(@NonNull Cargo cargo) {
        if (cargo.getWeight() <= freeSpace) {
            freeSpace -= cargo.getWeight();
            cargos.add(cargo);

            log.info("Cargo has been added!");

            return true;
        } else {
            throw new IllegalArgumentException("Cargo weight must be less than free space!");
        }
    }

    public boolean removeCargo(@NonNull String id) {
        for (Cargo cargo: cargos) {
            if (cargo.getId().equals(id)) {
                cargos.remove(cargo);

                log.info("Cargo has been removed!");

                return true;
            }
        }
        throw new  IllegalArgumentException("Cargo hasn't been found");
    }

    public Cargo getCargo(@NonNull String id) {
        for (Cargo cargo: cargos) {
            if (cargo.getId().equals(id)) {
                log.info("Cargo has been found!");
                return cargo;
            }
        }
        throw new  IllegalArgumentException("Cargo hasn't been found");
    }

    @Override
    public String toString() {
        return "Cargo wagon: " +
                "id: " + id + "\n" +
                "Cargos: " + cargos;
    }
}
