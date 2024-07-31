package de.supercode;

import java.util.List;

public class Checker {


    public static boolean hasUniceElements(List list) {
        return list.size() == new java.util.HashSet<>(list).size();
    }


    public static List removeAllDuplicates(List intList) {
        return new java.util.ArrayList<>(new java.util.HashSet<>(intList));
    }
}
