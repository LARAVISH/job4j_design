package ru.job4j.tree;

import java.util.Optional;

public interface Tree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    boolean isBinary();
}
