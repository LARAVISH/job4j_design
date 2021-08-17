package ru.job4j.iterator;


import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;


public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.nextIndex() == index) {
                listIterator.add(value);
                break;
            }
            listIterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.previousIndex() == index) {
                listIterator.add(value);
                break;
            }
            listIterator.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (filter.test(listIterator.next())) {
                listIterator.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (filter.test(listIterator.next())) {
                listIterator.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> list1) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            T t = listIterator.next();
            for (T el : list1) {
                if (el.equals(t)) {
                    listIterator.remove();
                }
            }
        }
    }
}
