package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Класс описывает унивкрсальную обуетку над массивом
 *
 * @author Lara Vish
 * @version 1
 */

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int index = 0;

    /**
     * Конструктор класса
     *
     * @param size - количество ячеек массива
     */
    @SuppressWarnings("unchecked")
    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    /**
     * метод описывает добавление элемента (model не null) в первую свободную ячейку
     *
     * @param model - добавляемый элемент
     */
    public void add(T model) {
        if (model != null) {
            this.array[index++] = model;
        }
    }

    /**
     * метод заменяет  указанным элементом (model) на позицию (position)
     *
     * @param position - индекс текущего элемента, который нужно заменить
     * @param model    - элемент, который нужно поставить на позицию
     */
    public void setIndex(int position, T model) {
        Objects.checkIndex(position, index);
        this.array[position] = model;
    }

    /**
     * метож возвращает элемен на позиции (position)
     *
     * @param position - индекс элемента, который нужно вернуть
     * @return array[checkIndex] элемент который находится по заданному индексу
     */
    public T get(int position) {
        int checkIndex = Objects.checkIndex(position, index);
        return array[checkIndex];
    }

    /**
     * метод удаляет элемент с заданной позиции (position)
     *
     * @param position - индекс элемента, который нужно удалить
     */
    public void remove(int position) {
        Objects.checkIndex(position, index);
        array[position] = null;
        System.arraycopy(array, position + 1, array, position, array.length - 1 - position);
        array[array.length - 1] = null;
        index--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
    }
}
