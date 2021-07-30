package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements Iterable<T> {
    private Object[] elementData;
    int modCount;
    int size = 0;
   private int capacity;

    public SimpleArrayList() {
        this.elementData = new Object[0];
    }
    public SimpleArrayList(int capacity) {
        this.elementData = new Object[capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    public void add(T model) {
        if (size >= elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        modCount++;
        elementData[size++] = model;

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
