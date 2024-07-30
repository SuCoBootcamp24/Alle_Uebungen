package de.supercode;

public class Box<E> {


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
}
