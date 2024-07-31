package de.supercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 5));

        System.out.println(Checker.hasUniceElements(list));
    }
}