package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void addBefore() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        ListUtils.addBefore(list, 1, 100);
        assertThat(Arrays.asList(1,100,2,3),is(list));
    }

    @Test
    public void addAfter() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        ListUtils.addAfter(list,0,100);
        assertThat(Arrays.asList(1,100,2,3), is(list));
    }

    @Test
    public void removeIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        Predicate<Integer> predicate = (s -> s == 3);
        ListUtils.removeIf(list,predicate);
        assertThat(Arrays.asList(1,2), is(list));
    }

    @Test
    public void replaceIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> predicate = (s -> s >= 2);
        ListUtils.replaceIf(list, predicate, 100);
        assertThat(Arrays.asList(1,100,100), is(list));

    }

    @Test
    public void removeAll() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(List.of(1));
        ListUtils.removeAll(list1,list2);
        assertThat(Arrays.asList(2,3), is(list1));
    }
    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }
}