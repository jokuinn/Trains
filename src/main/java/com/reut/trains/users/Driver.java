package com.reut.trains.users;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Driver extends User{
    public static final int WORKING_AGE = 18;

    private Boolean driverLicense;

    @Builder(toBuilder = true)
    public Driver(@NonNull String id, @NonNull String name, @NonNull String lastName, @NonNull Integer age, Boolean driverLicense) {
        super(id, name, lastName, age);
        this.driverLicense = driverLicense;
        if (age >= WORKING_AGE && driverLicense) {
            this.age =age;
        } else {
            throw new IllegalArgumentException("Driver must have a driver license and be over than 18 years old!");
        }
        log.info("Driver has been created!");
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverLicense=" + driverLicense +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
