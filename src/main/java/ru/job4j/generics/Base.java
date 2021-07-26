package ru.job4j.generics;

abstract class Base {
    private final String id;

    protected Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
