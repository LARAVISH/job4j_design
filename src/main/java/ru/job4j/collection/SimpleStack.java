package ru.job4j.collection;

public class SimpleStack<T>  {
    ForwardLinked<T> forwardLinked = new ForwardLinked<>();

    public T pop() {
        return forwardLinked.deleteFirst();

    }

    public void push(T value) {
        forwardLinked.add(value);
    }
}
