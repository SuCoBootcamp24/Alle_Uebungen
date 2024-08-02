package de.supercode;


import static de.supercode.Bubblesort.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------Low to Hight----------------");
        int[] list = new int[] {8,3,988,4,2,6,10000,45,57,78,0,64,334,6789,875,789,543,567,8900,7,433};
        displayArray(list);
        bubbleSortLowToHigh(list);
        displayArray(list);

        System.out.println("--------------High to Low------------------");
        int[] list2 = new int[] {8,3,988,4,2,6,10000,45,57,78,0,64,334,6789,875,789,543,567,8900,7,433};
        displayArray(list2);
        bubbleSortHighToLow(list2);
        displayArray(list2);


    }
    

    public static void displayArray(int[] list) {
        for (int i = 0; i < list.length; i++) System.out.print(STR."\{list[i]}, ");
        System.out.println();
    }
}