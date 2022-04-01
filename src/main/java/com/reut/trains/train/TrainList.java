package com.reut.trains.train;

import com.reut.trains.wagons.Wagon;

public interface TrainList {
    boolean add(Wagon wagon);
    boolean addFirst(Wagon wagon);
    boolean contains(Wagon wagon);
    boolean isEmpty();
    boolean remove(Wagon wagon);
    void clear();
    String toString();
}
