package ru.job4j.collection;

import java.util.Iterator;

public class ForwardLinkList<T> implements Iterable<T> {
    Node<T> head;
    Node<T> tail;

    public void addItemToEnd(T value) {
        Node<T> newItem = new Node<>();
        newItem.data = value;
        if (isEmpty()) {
            head = newItem;
            tail = newItem;
        }
        tail.next = newItem;
        tail = newItem;
    }

    public boolean reverse() {

        if (head == tail) {
            return false;
        }
        if (!isEmpty() && head.next != null) {
            tail = head;
            Node<T> current = head.next;
            head.next = null;
            while (current != null) {
                Node<T> next = current.next;
                current.next = head;
                head = current;
                current = next;

            }
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class Node<T> {
        Node<T> next;
        T data;
    }
}
