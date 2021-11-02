package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements Iterable<T> {
    private T[] elementData;
    int modCount;
    int size = 0;

    public SimpleArrayList() {
        this.elementData = (T[]) new Object[0];
    }

    public SimpleArrayList(int capacity) {
        this.elementData = (T[]) new Object[capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    public void add(T model) {

        T[] tmp = (T[]) elementData;
        elementData = (T[]) new Object[tmp.length + 1];
        System.arraycopy(tmp, 0, elementData, 0, tmp.length);
        elementData[elementData.length - 1] = model;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            int point = 0;
            private final int exModeCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (exModeCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elementData[point++];
            }
        };
    }
}
