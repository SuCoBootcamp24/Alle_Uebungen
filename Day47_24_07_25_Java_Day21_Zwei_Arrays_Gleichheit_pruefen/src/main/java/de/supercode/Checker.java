package de.supercode;

import java.util.HashMap;

public class Checker {

    private static HashMap<Integer, Integer> numberMap = new HashMap<>();


    public static HashMap<Integer, Integer> getNumberMap() {
        return numberMap;
    }

    public static void setNumberMap(HashMap<Integer, Integer> numberMap) {
        Checker.numberMap = numberMap;
    }

    public static boolean checkArrays(int[] array1, int[]array2) {
        if (array1.length != array2.length) return false;

        countAllNumbers(array1);
        return checkArrayValues(array2);
    }


    private static boolean checkArrayValues(int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            if (!numberMap.containsKey(array2[i])) return false;
            if (numberMap.get(array2[i]) == 1) numberMap.remove(array2[i]);
            else numberMap.put(array2[i], numberMap.get(array2[i]) - 1);
        }
        if (numberMap.isEmpty()) return true;
        return false;
    }

    private static void countAllNumbers(int[] array1) {
        for (int i = 0; i < array1.length; i++) {
           numberMap.put(array1[i], numberMap.getOrDefault(array1[i], 0) + 1);
        }
    }
}
