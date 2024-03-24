package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedTest {

    private DoubleLinked doubleList;
    @BeforeEach
    void setUp () {
        doubleList = new DoubleLinked();
    }
    @Test
    void add () {
        doubleList.add(1);
        Assertions.assertEquals(1,doubleList.head.value);
    }
    @Test
    void add_checkEnd () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(3,doubleList.end.value);
    }
    @Test
    void add_onZeroIndex () {
        doubleList.add(1);
        doubleList.add1(0,2);
        Assertions.assertEquals(1,doubleList.end.value);
        Assertions.assertEquals(2,doubleList.head.value);
    }
    @Test
    void add_onFirstHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.add(6);
        doubleList.add1(2,7);
        Assertions.assertEquals(7,doubleList.head.next.next.value);
        Assertions.assertEquals(6,doubleList.end.value);
    }
    @Test
    void add_onSecondHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.add(6);
        doubleList.add1(3,7);
        Assertions.assertEquals(7,doubleList.end.prev.prev.prev.value);
        Assertions.assertEquals(6,doubleList.end.value);
    }
    @Test
    void add_onNonExistentPosition () {
        doubleList.add(1);
        try {
            doubleList.add1(1,2);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void clear () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.clear();
        try {
            Assertions.assertEquals(2,doubleList.end.prev.value);
        } catch (NullPointerException exception) {}
    }
    @Test
    void remove_onFirstPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.remove(0);
        Assertions.assertEquals(2,doubleList.head.value);
    }
    @Test
    void remove_onSecondHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.remove(2);
        Assertions.assertEquals(2,doubleList.end.prev.prev.value);
    }
    @Test
    void remove_onFirstHalfIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        doubleList.add(5);
        doubleList.add(6);
        doubleList.remove(2);
        Assertions.assertEquals(4,doubleList.head.next.next.value);
    }
    @Test
    void remove_onLastPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.remove(2);
        Assertions.assertEquals(2,doubleList.end.value);
    }
    @Test
    void remove_onNonExistentPosition () {
        doubleList.add(1);
        try {
            doubleList.remove(1);
        } catch (IndexOutOfBoundsException exception) {}
    }
    @Test
    void findByIndex () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(1,doubleList.findByIndex(0));
    }
    @Test
    void findByIndex_onFirstPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        doubleList.add(4);
        Assertions.assertEquals(2,doubleList.findByIndex(1));
    }
    @Test
    void findByIndex_onSecondPosition () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.add(3);
        Assertions.assertEquals(2,doubleList.findByIndex(1));
    }
    @Test
    void print () {
        doubleList.add(1);
        doubleList.add(2);
        doubleList.print();
    }
}