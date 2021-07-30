package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayListTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddThenGet() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddThenIt() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.iterator().next();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCorruptedIt() {
        SimpleArrayList<String> array = new SimpleArrayList<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
    @Test
    public void whenAdd2ElementThenGet4El() {
        SimpleArrayList<String> array = new SimpleArrayList<>(2);
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        String rsl = array.get(2);
        String rsl2 = array.get(3);
        assertThat(rsl, is("3"));
        assertThat(rsl2, is("4"));
    }
}