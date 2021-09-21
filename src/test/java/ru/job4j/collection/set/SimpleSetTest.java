package ru.job4j.collection.set;

import org.junit.Test;

import java.util.NoSuchElementException;

public class SimpleSetTest {

    @Test(expected = NoSuchElementException.class)
    public void whenAddNotNull() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.contains(1);
        set.add(1);
        set.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        set.add(null);
        set.contains(null);
        set.add(null);
        set.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Set<Integer> set = new SimpleSet<>();
        set.iterator().next();
    }
}