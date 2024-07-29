package de.supercode;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> students = new LinkedList<>();

        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("Diana");
        students.add("Eve");

        //------

        students.addFirst( "Zara");
        students.addLast("Fred");

        System.out.println("first: " + students.getFirst() + " last: " + students.getLast());
        System.out.println();
        System.out.println("Index 2: = " + students.get(2));

        //------

        students.removeFirst();
        students.removeLast();
        students.remove(1);

        //------

        System.out.println(students.contains("Alice"));
        System.out.println(students.contains("Eve"));
        System.out.println(students.indexOf("charlie"));

        //------
        System.out.println("Iterieren und Anzeigen: ");
        for (String student : students) {
            System.out.println("\t" + student);
        }

        //------

        LinkedList<String> newStudent = new LinkedList<>(Arrays.asList("George", "Hannah"));
        students.addAll(newStudent);

        students.sort(String::compareToIgnoreCase);

        //------
        System.out.println("Alle elemente");

        for (String student : students) {
            System.out.println("\t" + student);
        }

        System.out.println("das 2. element von hinten: ");
        printObjectKFromTheLastInArray(students, 2);


    }


    private static void printObjectKFromTheLastInArray(LinkedList list, int k) {
        if (list.size() < k) {
            System.out.println("Es sind nicht genug Elemente vorhanden.");
            return;
        }

        int index = list.size() - k;
        System.out.println("Element an der Position " + index + ": " + list.get(index));

    }
}