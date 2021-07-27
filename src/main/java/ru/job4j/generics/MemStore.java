package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** the class - universal holder
 * @author Lara Vish
 */


public class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    /**
     * the method adds not null element
     *
     * @param model - value
     */
    @Override
    public void add(T model) {
        mem.putIfAbsent(model.getId(), model);
    }

    /**
     * the method replaces element at the position of the key
     *
     * @param id    key
     * @param model value
     * @return res true or false
     */
    @Override
    public boolean replace(String id, T model) {
        if (!mem.containsKey(id)) {
            return false;
        }
        mem.replace(id, model);
        return true;
    }

    /**
     * the method deletes element
     *
     * @param id - key
     * @return res true or false
     */
    @Override
    public boolean delete(String id) {
        if (!mem.containsKey(id)) {
            return false;
        }
        mem.remove(id);
        return true;
    }

    /**
     * the method searches for.. by number id
     *
     * @param id key
     * @return type T
     */
    @Override
    public T findBy(String id) {
        if (!mem.containsKey(id)) {
            return null;
        }
        return mem.get(id);
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
