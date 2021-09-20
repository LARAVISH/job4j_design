package ru.job4j.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Node<E> current = new Node<>(child);
        Node<E> node;
        List<Node<E>> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            node = list.remove(0);
            if (node.value.equals(parent)
                    && !node.children.contains(current)) {
                node.children.add(current);
                rsl = true;
                break;
            }
            list.addAll(node.children);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}