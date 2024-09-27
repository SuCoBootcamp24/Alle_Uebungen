package de.supercode;

import java.util.ArrayList;
import java.util.List;


public class MyOwnStack<T> {
    private List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        T element = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return element;
    }

    public T peek() {
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }
}
