package de.supercode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKG_BLACK_TEXT = "\u001B[42;30m";
    public static final String ANSI_YELLOW_BACKG_BLACK_TEXT = "\u001B[43;30m";

    final static int WARM_UP_SIZE = 10000;
    final static int MAX_SIZE = 1000000;

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList();
        LinkedList<String> linkedList = new LinkedList();

        // 1. Wurm up ArrayList and LinkedList
        warmUp(arrayList, linkedList);




        //2. Hinzufügen von Elementen
        //2.1 Arraylist
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_SIZE; i++) {
            arrayList.add("Element " + i);
        }
        long endTime = System.currentTimeMillis();
        long arrayListAddElementsTime = endTime - startTime;

        //2.2 LinkedList
         startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_SIZE; i++) {
            linkedList.add("Element " + i);
        }
         endTime = System.currentTimeMillis();
        long linkedListAddElementsTime = endTime - startTime;




        //3. hinzufügen von Elementen am Anfang
        //3.1 ArrayList
        startTime = System.nanoTime();
        arrayList.addFirst("First Element" + 0);
        endTime = System.nanoTime();
        long arrayListAddFirstElementTime = endTime - startTime;

        //3.2 LinkedList
        startTime = System.nanoTime();
        linkedList.addFirst("First Element" + 0);
        endTime = System.nanoTime();
        long LinkedListAddFirstElementTime = endTime - startTime;




        //4. Entfernen eines Elements aus der Mitte
        //4.1 ArrayList
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        endTime = System.nanoTime();
        long arrayListRemoveMiddleElementTime = endTime - startTime;

        //4.2 LinkedList
        startTime = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        endTime = System.nanoTime();
        long linkedListRemoveMiddleElementTime = endTime - startTime;




        //5. Zugriff auf ein bestimmtes Element
        //5.1 ArrayList
        startTime = System.nanoTime();
        arrayList.get(315);
        endTime = System.nanoTime();
        long arrayListGetElementTime = endTime - startTime;

        //5.2 LinkedList
        startTime = System.nanoTime();
        linkedList.get(315);
        endTime = System.nanoTime();
        long linkedListGetElementTime = endTime - startTime;




        //6. Iterieren durch eine Liste
        //6.1 Arraylist
        startTime = System.currentTimeMillis();
        for (String element : arrayList) {
            System.out.println(element);
        }
        endTime = System.currentTimeMillis();
        long arrayListIterateTime = endTime - startTime;

        //6.2 LinkedList
        startTime = System.currentTimeMillis();
        for (String element : linkedList) {
            System.out.println(element);
        }
        endTime = System.currentTimeMillis();
        long linkedListIterateTime = endTime - startTime;



        //7. Entfernen des ersten Elementes:
        //7.1 ArrayList
        startTime = System.nanoTime();
        arrayList.removeFirst();
        endTime = System.nanoTime();
        long arrayListRemoveFirstElementTime = endTime - startTime;

        //7.2 LinkedList
        startTime = System.nanoTime();
        linkedList.removeFirst();
        endTime = System.nanoTime();
        long LinkedListRemoveFirstElementTime = endTime - startTime;




        System.out.println();
        System.out.println();
        System.out.println("Statistik für ArrayList und LinkedList:");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-40s %10s %10s\n", "", "ArrayList", "    LinkedList");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-40s %10s %10s %s\n", "  Hinzufügen von Elementen (1.000.000E):", arrayListAddElementsTime , linkedListAddElementsTime, ANSI_YELLOW_BACKG_BLACK_TEXT + "ms" + ANSI_RESET);
        System.out.printf("%-40s %10d %10d %s\n", "  Hinzufügen von Elementen am Anfang:", arrayListAddFirstElementTime, LinkedListAddFirstElementTime, ANSI_GREEN_BACKG_BLACK_TEXT + "ns" + ANSI_RESET);
        System.out.printf("%-40s %10d %10d %s\n", "  Entfernen eines Elements am Mitte:", arrayListRemoveMiddleElementTime, linkedListRemoveMiddleElementTime, ANSI_GREEN_BACKG_BLACK_TEXT + "ns" + ANSI_RESET);
        System.out.printf("%-40s %10d %10d %s\n", "  Zugriff auf ein bestimmtes Element:", arrayListGetElementTime, linkedListGetElementTime, ANSI_GREEN_BACKG_BLACK_TEXT + "ns" + ANSI_RESET);
        System.out.printf("%-40s %10s %10s %s\n", "  Iterieren durch eine Liste:", arrayListIterateTime, linkedListIterateTime, ANSI_YELLOW_BACKG_BLACK_TEXT + "ms" + ANSI_RESET);
        System.out.printf("%-40s %10d %10d %s\n", "  Entfernen des ersten Elementes:", arrayListRemoveFirstElementTime, LinkedListRemoveFirstElementTime, ANSI_GREEN_BACKG_BLACK_TEXT + "ns" + ANSI_RESET);
        System.out.println("--------------------------------------------------------------------");

    }


    private static void warmUp(ArrayList<String> arrayList, LinkedList<String> linkedList) {

        for (int i = 0; i < WARM_UP_SIZE; i++) {
            arrayList.add("WarmUp " + i);
            linkedList.add("WarmUp " + i);
        }

        arrayList.clear();
        linkedList.clear();

    }

}