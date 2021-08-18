package ru.job4j.collection.set;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleArray<T> implements Iterable<T> {

    T[] array;
    int size = 0;
    int count;

    public void add(T value) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        count++;
        array[size++] = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }
}
