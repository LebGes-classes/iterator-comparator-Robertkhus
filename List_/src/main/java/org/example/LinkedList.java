package org.example;

public class LinkedList<T> {
Node head;
public void add(Node elem) {
    if(head == null) {
        head = elem;
    }else {
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = elem;
    }
}
public void add1(Node elem,int index) {
    if(head == null) {
        head = elem;
    }else {
        Node current = head;
        int count = 0;
        while(count != index - 1) {
            current = current.next;
            count++;
        }
        elem.next = current.next;

        current.next = elem;
    }
}
public void print() {
    if(head != null) {
        Node current = head;
        while(current.next != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print(current.value);
    }
}
public void delete(T x) {
    if(head != null) {
        Node current = head;
        while(current.next != null) {
            if(current.next.value == x) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }
}
public int find(T x) {
    if(head != null) {
        Node current = head;
        int count = 0;
        while(current.next != null) {
            if(current.value == x) {
                return count;
            } else {
                current = current.next;
                count++;
            }
        }
        if(current.value == x) {
            return count;
        }
    }
    return -1;
}
public T findInd (int index) {
    Node<T> current = head;
    int count = 0;
    while(current.next != null && index == count ) {
        current = current.next;
        count++;
    }
    if(current.next == null) {
        throw new IndexOutOfBoundsException();
    }

    return current.next.value;
}
public void clear() {
    head = null;
}
}
