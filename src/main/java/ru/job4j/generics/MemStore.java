package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



public class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        if (model != null) {
            mem.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        T t = findBy(id);
        for (String s : mem.keySet()) {
            if (t.getId().equals(id)) {
                mem.replace(s, model);
                res = true;
                break;
            }
        }

        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        T t = findBy(id);
        if (t.getId().equals(id)) {
            mem.remove(t.getId());
            res = true;
        }
        return res;
    }

    @Override
    public T findBy(String id) {
        T base = null;
        for (T t : mem.values()) {
            if (t.getId().equals(id)) {
                base = t;
                break;
            }
        }
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MemStore)) {
            return false;
        }
        MemStore<?> memStore = (MemStore<?>) o;
        return Objects.equals(mem, memStore.mem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mem);
    }
}
