package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
        }
        Node<T> tail = head;
        while (tail != null) {
            tail = tail.next;
        }
    }

    public T deleteFirst() {
        if (head != null) {
            T value = head.value;
            head = head.next;
            return value;
        }
        throw new NoSuchElementException();
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                node = node.next;
                return null;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
