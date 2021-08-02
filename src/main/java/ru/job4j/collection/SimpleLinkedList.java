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
        Node<E> tmp = head;
        Objects.checkIndex(index, size);
        return tmp.getItem();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

             int point;
             int exModCount;
            private Node<E> item;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (exModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) new Node<>(item.getItem());
            }
        };
    }

    private static class Node<E> {


        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }

        private final E item;
        private Node<E> next;

        private Node(E item) {
            this.item = item;

        }
    }
}
