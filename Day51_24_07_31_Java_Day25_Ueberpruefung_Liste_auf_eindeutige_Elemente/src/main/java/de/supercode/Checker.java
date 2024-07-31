package de.supercode;

import java.util.List;

public class Checker {


    public static boolean hasUniceElements(List list) {
        return list.size() == new java.util.HashSet<>(list).size();
    }
}
