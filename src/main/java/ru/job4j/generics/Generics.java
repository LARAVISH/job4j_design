package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
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

        generics.printBoundedWildCard(first);
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerWildCard(first);
        generics.printLowerWildCard(second);
        generics.printLowerWildCard(third);
    }

    public void printObjects(List<?> list) {
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("current element " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Animal> predators) {
        for (Iterator<? extends Animal> iterator = predators.iterator(); iterator.hasNext();) {
            Animal next = iterator.next();
            System.out.println("current element " + next);
        }
    }

    public void printLowerWildCard(List<? super Tiger> list) {
        for (Iterator<? super Tiger> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("current element " + next);
        }
    }
}
