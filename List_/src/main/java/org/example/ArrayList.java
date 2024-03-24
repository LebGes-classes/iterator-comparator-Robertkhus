package org.example;

public class ArrayList<T> {
    int size;
    int capacity;
    T[] array;
    public ArrayList() {
        capacity = 16;
        array = (T[]) new Object[capacity];
    }
    public void increaseCapacity() {
        capacity = capacity * 2;
        T[] newArray = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public void add(T elem) {
        if (size + 1 > capacity) {
            increaseCapacity();
        }
        array[size] = elem;
        size++;
    }
    public void add1(int index,T elem) {
        if(size + 1 > capacity) {
            increaseCapacity();
        }
        array[size + 1] = elem;
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        for(int i = 0; i < (size - index); i++) {
            T tmp = array[size - i];
            array[size - i] = array[size - i - 1];
            array[size - i - 1] = tmp;
        }
    }
    public void clear() {
        array = null;
        size = 0;
    }
    public void remove (int index) {
        if (size < capacity/2) {
            T[] newArr = (T[]) new Object[capacity / 2];
            for (int i = 0; i < size; i++) {
                if (index == i) continue;
                newArr[i] = array[i];
            }
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i+1];
            }
        }
    }

    public T findByIndex(int index) {
        return array[index];
    }
    public boolean isEmpty() {
        return  array != null;
    }
    public void print() {
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
    }

}
