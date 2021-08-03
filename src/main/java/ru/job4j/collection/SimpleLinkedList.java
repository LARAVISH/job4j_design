package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<E> tmp = head;
            while (tmp != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node<>(value));
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> tmp = head;
        for (int i = 0; i <= index; i++) {
            tmp = tmp.getNext();
        }
        return tmp.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int exModCount;
            private Node<E> item = head;

            @Override
            public boolean hasNext() {
                return item != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (exModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E el = item.getValue();
                item = item.getNext();
                return el;
            }
        };
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node<E> getNext() {
            return next;
        }

        private Node(E item) {
            this.value = item;
        }

        public E getValue() {
            return value;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
