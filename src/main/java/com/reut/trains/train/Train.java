package com.reut.trains.train;

import com.reut.trains.wagons.Wagon;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Train implements TrainList {

    @NonNull
    private final Integer number;

    private Node<Wagon> first;
    private Node<Wagon> last;

    private int size = 0;

    public Train(Integer number) {

        if(number == 0) {
            throw new IllegalArgumentException("Invalid number of train");
        }

        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Wagon getFirst() {
        if (isEmpty()) {
            log.info("Train is empty!");
            return null;
        } else {
            return first.wagon;
        }
    }

    public Wagon getLast() {
        if (isEmpty()) {
            log.info("Train is empty!");
            return null;
        } else {
            return last.wagon;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean add(@NonNull Wagon wagon) {
        Node<Wagon> newNode = new Node<>(wagon);

        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;

        log.info("Wagon was successfully added!");

        return true;
    }

    @Override
    public boolean addFirst(@NonNull Wagon wagon) {
        Node<Wagon> newNode = new Node<>(wagon);

        if (this.first == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.first.next;
            newNode.prev = this.first;
            this.first.next.prev = newNode;
            this.first.next = newNode;
        }
        size++;
        log.info("Wagon was successfully added into the beginning of the train!");
        return true;
    }

    @Override
    public boolean contains(@NonNull Wagon wagon) {
        for(Node<Wagon> temp = first; temp != null; temp = temp.next){
            if(temp.wagon.equals(wagon)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(Wagon wagon) {
        Node<Wagon> current = first;
        while (current != null && current.wagon != wagon) {
            current = current.next;
        }

        if(current == null) {
            return false;
        }

        removeNode(current);
        return true;
    }

    private void removeNode(@NonNull Node<Wagon> node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            first = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }
        size--;
    }

    @Override
    public void clear() {
        for(Node<Wagon> temp = first; temp!=null;){
            temp.wagon = null;
            Node<Wagon> node = temp.next;
            temp.next = null;
            temp.prev = null;
            temp = node;
        }

        this.size = 0;
    }

    private static class Node<T> {

        Node<T> next;
        Node<T> prev;
        T wagon;

        public Node(T wagon) {
            this.wagon = wagon;
        }
    }
}