package ru.job4j.collection;


import java.util.EmptyStackException;


public class SimpleStack<T> {
    ForwardLinked<T> linked = new ForwardLinked<>();


    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return linked.empty();
    }
}
