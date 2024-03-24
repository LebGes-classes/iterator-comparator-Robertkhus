package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    private LinkedList list;
    @BeforeEach
    void setUp () {
        list = new LinkedList();
    }
    @Test
    void add () {
        list.add(new Node(1));
        Assertions.assertEquals(1,list.head.value);
        list.add(new Node(2));
        list.add(new Node(3));
        Assertions.assertEquals(3,list.head.next.next.value);
    }
    @Test
    void add1 () {
        list.add1(new Node(1),0);
        list.add1(new Node(2),1);
        list.add1(new Node(3),2);
        list.add1(new Node(4),3);
        Assertions.assertEquals(4,list.head.next.next.next.value);
    }
    @Test
    void delete () {
        list.add(new Node(1));
        list.add(new Node(2));
        list.delete(2);
        Assertions.assertEquals(1,list.head.value);
    }
    @Test
    void print () {
        list.add(new Node(1));
        list.add(new Node(2));
        list.print();
    }
    @Test
    void find () {
        list.add(new Node(1));
        list.add(new Node(2));
        Assertions.assertEquals(0,list.find(1));
        Assertions.assertEquals(1,list.find(2));
        Assertions.assertEquals(-1,list.find(3));
    }
    @Test
    void clear () {
        list.add(new Node(1));
        list.add(new Node(2));
        list.clear();
        Assertions.assertNull(list.head);
    }
}
