package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int index = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray(int size) {
        this.array = (T[]) new Object[ size ];
    }

    public void add(T model) {
        if (model != null) {
            this.array[ index++ ] = model;
        }
    }

    public void setIndex(int position, T model) {
        Objects.checkIndex(position, array.length);
        this.array[position] = model;
    }

    public T get(int position) {
        int checkIndex = Objects.checkIndex(position, array.length);
        return array[checkIndex];
    }

    public void remove(int position) {

        Objects.checkIndex(position, array.length);
        array[ position ] = null;
        System.arraycopy(array, position + 1, array, position, array.length - 1 - position);
        array[ array.length - 1 ] = null;
        index--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
    }
}
