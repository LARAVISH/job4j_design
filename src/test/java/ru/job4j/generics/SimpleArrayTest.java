package ru.job4j.generics;

import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenAddElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(3);
        assertThat(simpleArray.get(0), is(3));
    }

    @Test
    public void getElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        assertThat(simpleArray.get(0),is(1));
    }

    @Test
    public void whenReplaceElement() {
        SimpleArray<String> strings = new SimpleArray<>(5);
        strings.add("hello");
        strings.add("world");
        strings.setIndex(0,"friend");
        assertThat(strings.get(0), is("friend"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidIndex() {
        SimpleArray<Integer> numbers = new SimpleArray<>(2);
        numbers.get(2);
    }

    @Test
    public void whenAddElementInEmptyCell() {
        SimpleArray<Integer> strings = new SimpleArray<>(3);
        strings.add(1);
        strings.add(2);
        strings.add(3);
        strings.remove(1);
        strings.add(5);
        assertThat(strings.get(2), is(5));
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> numbers = new SimpleArray<>(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.remove(2);
        assertNull(numbers.get(4));
        assertThat(numbers.get(2), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterate() {
        SimpleArray<Integer> numbers = new SimpleArray<>(3);
        numbers.add(1);
        numbers.add(0);
        numbers.add(-3);
        Iterator<Integer> iterator = numbers.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(-3));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayIsEmpty() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        Iterator<Integer> iterator = array.iterator();
        iterator.next();
    }
}