package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArrayList;



import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

   SimpleArrayList<T> set = new SimpleArrayList<>();


    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (T el : set) {
            if (Objects.equals(el, value)) {
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleSet)) {
            return false;
        }
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(set, simpleSet.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

}
