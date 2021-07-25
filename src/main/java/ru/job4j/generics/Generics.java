package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        generics.printObjects(first);
        generics.printObjects(second);
        generics.printObjects(third);
        System.out.println();

       // generics.printBoundedWildCard(first);
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerWildCard(first);
        generics.printLowerWildCard(second);
       // generics.printLowerWildCard(third);
    }

    public void printObjects(List<?> list) {
        for (Object next : list) {
            System.out.println("current element " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> predators) {
        for (Predator next : predators) {
            System.out.println("current element " + next);
        }
    }

    public void printLowerWildCard(List<? super Predator> list) {
        for (Object next : list) {
            System.out.println("current element " + next);
        }
    }
}
