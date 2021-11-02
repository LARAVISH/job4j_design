package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;


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
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            return deleteFirst();
        }
        Node<T> node = head;
        Node<T> tNode = null;
        while (node.next != null) {
            tNode = node;
            node = node.next;
        }
        T value = tNode.next.value;
        tNode.next = null;
        return value;
    }

    public boolean empty() {
        return head == null;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (empty()) {
            head = node;
        }
        Node<T> tmp = new Node<>(value, null);
        tmp.next = head;
        head = tmp;
    }

    public boolean reverse() {
        boolean res = false;
        if (!empty() && head.next != null) {
            head = tail;
            Node<T> current = head.next;
            head.next = null;
            while (current.next != null) {
                Node<T> next = current.next;
                current.next = head;
                head = current;
                current = next;
            }
            res = true;
        }
        return res;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
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

    public static void main(String[] args) {
        ForwardLinked<Integer> forwardLinked = new ForwardLinked<>();
        forwardLinked.add(1);
        forwardLinked.add(2);
        forwardLinked.add(3);
        for (Integer i : forwardLinked) {
            System.out.println(i);
        }
        System.out.println("____________________");
        forwardLinked.reverse();

    }
}
