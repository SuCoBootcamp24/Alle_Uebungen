package de.supercode;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------Pivot High----------------");
        int[] list = new int[] {8,3,988,4,2,6,10000,45,57,78,0,64,334,6789,875,789,543,567,8900,7,433,1};
        displayArray(list);
        Quicksort.quickSortPivotHigh(list);
        displayArray(list);
        System.out.println();


        System.out.println("---------------Pivot mid----------------");
        int[] list2 = new int[] {8,3,988,4,2,6,10000,45,57,78,0,64,334,6789,875,789,543,567,8900,7,433,1};
        displayArray(list2);
        Quicksort.quickSortPivotHigh(list2);
        displayArray(list2);
        System.out.println();


        System.out.println("---------------Pivot random----------------");
        int[] list3 = new int[] {8,3,988,4,2,6,10000,45,57,78,0,64,334,6789,875,789,543,567,8900,7,433,1};
        displayArray(list3);
        Quicksort.quickSortPivotHigh(list3);
        displayArray(list3);
        System.out.println();






    }


    public static void displayArray(int[] list) {
        for (int j : list) System.out.print(STR."\{j}, ");
        System.out.println();
    }
}