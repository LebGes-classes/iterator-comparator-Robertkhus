package org.example;

import java.util.NoSuchElementException;

public class DoubleLinked<T> implements Iterable<T> {
        Node<T> head;
        Node<T> end;
        int size;
        public void add (T data) {
            Node<T> node = new Node(data);
            if (head == null) {
                head = node;
                end = node;
            } else {
                end.next = node;
                node.prev = end;
                end = node;
            }
            size++;
        }
        public void add1 (int index, T data) {
            Node<T> node = new Node(data);
            Node<T> curH = head;
            Node<T> curE = end;
            if (index == 0) { // вставка на 0 позицию
                head = node;
                head.next = curH;
                curH.prev = node;
            } else if (index > size - 1) { // вставка на несуществующую позицию
                throw new IndexOutOfBoundsException();
            } else { // вставка на произвольную позицию
                if (index < size / 2) { // вставка в первую половину списка
                    int counter = 0;
                    while (index > counter + 1) { // остановка перед нужным "индексом", куда хотим добавлять
                        curH = curH.next;
                        counter++;
                    }
                    node.next = curH.next;
                    curH.next.prev = node;
                    curH.next = node;
                    node.prev = curH;
                } else { // вставка во вторую половину списка
                    int requiredOfSteps = size - index - 1;
                    int stepsCounter = 0;
                    while (requiredOfSteps > stepsCounter) {
                        curE = curE.prev;
                        stepsCounter++;
                    }
                    node.next = curE;
                    curE.prev.next = node;
                    node.prev = curE.prev;
                    curE.prev = node;
                }
            }
            size++;
        }
        public void remove (int index) {
            Node<T> curH = head;
            Node<T> curE = end;
            if (index == 0) { // // ремув с 0 позиции
                head = head.next;
            } else if (index == size - 1) { // ремув с последней позиции
                end = end.prev;
            } else if (index > size - 1) { // ремув с несуществующей позиции
                throw new IndexOutOfBoundsException();
            } else {
                if (index < size / 2) {
                    int counter = 0;
                    while (index > counter + 1) { // остановка перед нужным "индексом", откуда хотим удалять
                        curH = curH.next;
                        counter++;
                    }
                    curH.next = curH.next.next;
                    curH.next.next.prev = curH;
                } else {
                    int requiredOfSteps = size - index - 2;
                    int stepsCounter = 0;
                    while (requiredOfSteps > stepsCounter) { // остановка перед нужным "индексом", откуда хотим удалять
                        curE = curE.prev;
                        stepsCounter++;
                    }
                    curE.prev.prev.next = curE;
                    curE.prev = curE.prev.prev;
                }
            }
            size--;
        }
        public int findByValue (T data) {
            Node<T> cur = head;
            int counter = 0;
            while (cur != null) {
                if (cur.value == data) {
                    return counter;
                }
                cur = cur.next;
                counter++;
            }
            return -1;
        }
        public T findByIndex (int index) {
            if (index > size - 1) {
                throw new IndexOutOfBoundsException(); // проброс исключения при вводе несуществующего индекса
            } else if (index < size / 2) { // если элемент в первой части списка
                int counter = 0;
                Node<T> curH = head;
                while (index != counter) {
                    curH = curH.next;
                    counter++;
                }
                return curH.value;

            } else { // если элемент во второй части списка
                int requiredOfSteps = size - index - 1;// нужное кол-во шагов
                int stepsCounter = 0;
                Node<T> curE = end;
                while (requiredOfSteps > stepsCounter) {
                    curE = curE.prev;
                    stepsCounter++;
                }
                return curE.value;
            }
        }
    public void clear () {
        head = null;
        end = null;
        size = 0;
    }
    public void print() {
        if(head != null) {
            Node<T> current = head;
            while(current.next != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.print(current.value);
        }
    }
    public Iterator<T> iterator() {
        return new Iterator<>(this);
    }
    private class Iterator<T> implements java.util.Iterator<T> {

        private int i;
        private Node<T> cur;

        public Iterator(DoubleLinked<T> list) {
            this.cur = list.head;
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            try {
                Node<T> tmp = cur;
                i++;
                if (hasNext()) {
                    cur = cur.next;
                }
                return tmp.value;
            } catch (NoSuchElementException ex) {
                throw new NoSuchElementException(ex);
            }
        }

        @Override
        public void remove() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            cur.prev.next = cur.next;
            cur.next = cur.prev.prev;
        }
    }
}