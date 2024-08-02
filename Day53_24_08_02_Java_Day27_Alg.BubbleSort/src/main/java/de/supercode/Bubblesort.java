package de.supercode;

public class Bubblesort {




    public static void bubbleSortLowToHigh(int[] unsortedList) {
        int listLength= unsortedList.length;

        for (int i = 0; i < listLength - 1; i++) {
            for (int j = 0; j < listLength - i - 1; j++) {
                if (unsortedList[j] > unsortedList[j + 1]) {
                    int temp = unsortedList[j];
                    unsortedList[j] =  unsortedList[j + 1];
                    unsortedList[j + 1] = temp;
                }

            }
        }
    }


    public static void bubbleSortHighToLow(int[] unsortedList) {
        int listLength= unsortedList.length;

        for (int i = 0; i < listLength - 1; i++) {
            for (int j = 0; j < listLength - i - 1; j++) {
                if (unsortedList[j] < unsortedList[j + 1]) {
                    int temp = unsortedList[j];
                    unsortedList[j] =  unsortedList[j + 1];
                    unsortedList[j + 1] = temp;
                }

            }
        }
    }

}
