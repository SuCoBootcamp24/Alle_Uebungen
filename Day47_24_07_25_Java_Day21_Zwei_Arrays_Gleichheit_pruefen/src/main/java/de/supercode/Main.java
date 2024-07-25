package de.supercode;

public class Main {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 3, 3, 4, 5};
        int[] list2 = {3, 5, 1, 4, 2, 3};

        System.out.println(Checker.checkArrays(list1, list2));
        System.out.println(Checker.getNumberMap());

        System.out.println("--------------------------------");

        int[] list3 = {1, 2, 3, 3, 4, 5};
        int[] list4 = {1, 2, 3, 4, 3, 3};

        System.out.println(Checker.checkArrays(list3, list4));
        System.out.println(Checker.getNumberMap());
    }
}