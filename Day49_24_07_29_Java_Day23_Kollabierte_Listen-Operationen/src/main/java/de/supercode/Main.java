package de.supercode;

import java.util.LinkedList;

import static de.supercode.CollapseDuplicates.collapseDuplicates;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);

        System.out.println("Original List: " + list);
        collapseDuplicates(list);
        System.out.println("Collapsed List: " + list);
    }
}