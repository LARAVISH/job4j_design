package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ForwardLinkListTest {

    @Test
    public void whenAddThenIter() {
       ForwardLinkList<Integer> linked = new  ForwardLinkList<>();
        linked.addItemToEnd(1);
        linked.addItemToEnd(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkList<Integer> linked = new  ForwardLinkList<>();
        linked.addItemToEnd(1);
        linked.addItemToEnd(2);
        linked.reverse();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenSize0ThenReturnFalse() {
        ForwardLinkList<Integer> linked = new  ForwardLinkList<>();
        assertFalse(linked.reverse());
    }

    @Test
    public void whenSize1ThenReturnFalse() {
        ForwardLinkList<Integer> linked = new  ForwardLinkList<>();
        linked.addItemToEnd(1);
       assertThat(false, is(linked.reverse()));
    }
}