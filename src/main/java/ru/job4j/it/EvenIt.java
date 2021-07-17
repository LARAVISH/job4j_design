package ru.job4j.it;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    private final int[] data;
    private int nextEventNumber = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (getEventNumber(data[nextEventNumber])) {
            return true;
        }
        while (nextEventNumber < data.length - 1) {
            if (getEventNumber(data[nextEventNumber])) {
                break;
            }
            nextEventNumber++;
        }
        return getEventNumber(data[nextEventNumber]);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[nextEventNumber++];
    }

    public boolean getEventNumber(int number) {
        return number % 2 == 0;
    }
}
