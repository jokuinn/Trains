package com.reut.trains.users;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public abstract class User {
    public static final int MAX_AGE = 100;
    public static final int MIN_AGE = 0;

    @NonNull
    protected String id;

    @NonNull
    protected String name;

    @NonNull
    protected String lastName;

    @NonNull
    protected Integer age;

    public User(@NonNull String id, @NonNull String name, @NonNull String lastName, @NonNull Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        if (MIN_AGE < age && age < MAX_AGE) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("User can't have this age!");
        }
        log.info("User has been created!");
    }

}
