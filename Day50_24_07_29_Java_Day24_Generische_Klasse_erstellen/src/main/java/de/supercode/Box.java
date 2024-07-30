package de.supercode;

import java.util.ArrayList;

public class Box<E> {

    private ArrayList<E> list;

    private E object;

    public Box(E object) {
        this.object = object;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    //-------

    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
