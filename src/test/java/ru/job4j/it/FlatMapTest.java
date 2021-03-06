package ru.job4j.it;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FlatMapTest {
    public FlatMapTest() {
    }

    @Test
    public void whenDiffNext() {
        Iterator<Iterator<Integer>> data = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Arrays.asList(2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
    }

    @Test
    public void whenSeqNext() {
        Iterator<Iterator<Integer>> data = Collections.singletonList(
                Arrays.asList(1, 2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
    }

    @Test
    public void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = Collections.singletonList(
                Collections.singletonList(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.hasNext(), is(true));
        assertThat(flat.hasNext(), is(true));
    }

    @Test
    public void whenHasNextFalse() {
        Iterator<Iterator<Integer>> data = Collections.singletonList(
                Collections.singletonList(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Iterator<Iterator<Object>> data = Collections.singletonList(
                Collections.emptyIterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(data);
        flat.next();
    }
}