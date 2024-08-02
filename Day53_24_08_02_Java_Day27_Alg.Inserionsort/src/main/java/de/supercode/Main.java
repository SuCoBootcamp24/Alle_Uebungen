package de.supercode;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------Insertion low to high----------------");
        int[] list = new int[] {8,3,988,4,2,6,10000,45,57,78,0,64,334,6789,875,789,543,567,8900,7,433,1};
        displayArray(list);
        InsertionSort.InsertionSortLowToHigh(list);
        displayArray(list);
        System.out.println();
    }


    public static void displayArray(int[] list) {
        for (int j : list) System.out.print(STR."\{j}, ");
        System.out.println();
    }
}
