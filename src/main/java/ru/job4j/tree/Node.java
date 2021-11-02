package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<E> {
    final E value;
    final List<Node<E>> children = new ArrayList<>();

    public Node(E value) {
        this.value = value;
    }
    public void add(Node<E> child) {
        this.children.add(child);
    }
}
