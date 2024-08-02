package de.supercode;

public class Quicksort {



    public static void quickSortPivotHigh(int[] array) {
        if (array.length < 1) return;
        else quickSortPivotHigh(array, 0, array.length -1);
    }

    private static void quickSortPivotHigh(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partitionPivotHigh(array, low, high);

            quickSortPivotHigh(array, low, pivot - 1);
            quickSortPivotHigh(array, pivot + 1, high);
        }
    }

    private static int partitionPivotHigh(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {  // falls von gros zu kein sotiert muss hier das < gedreht werden
                i++;

                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);

        return (i + 1);
    }


    //------------
    public static void quickSortPivotMid(int[] array) {
        if (array.length < 1) return;
        else quickSortPivotMid(array, 0, array.length -1);
    }

    private static void quickSortPivotMid(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partitionPivotMid(array, low, high);

            quickSortPivotMid(array, low, pivot - 1);
            quickSortPivotMid(array, pivot + 1, high);
        }
    }

    private static int partitionPivotMid(int[] array, int low, int high) {
        int pivot = array[(low + high) / 2];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }


    //------------
    public static void quickSortPivotRandom(int[] array) {
        if (array.length < 1) return;
        else quickSortPivotRandom(array, 0, array.length -1);
    }

    private static void quickSortPivotRandom(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partitionPivotRandom(array, low, high);

            quickSortPivotRandom(array, low, pivot - 1);
            quickSortPivotRandom(array, pivot + 1, high);
        }
    }

    private static int partitionPivotRandom(int[] array, int low, int high) {
        int pivot = array[(int) (Math.random() * array.length-1)];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                swap(array, i, j);
            }
        }

        swap(array,i + 1, high);
        return i + 1;
    }












    private static void swap(int[] array, int i, int high) {
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
    }


}
