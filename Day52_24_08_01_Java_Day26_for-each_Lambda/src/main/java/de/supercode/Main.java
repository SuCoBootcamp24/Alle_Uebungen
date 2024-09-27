package de.supercode;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1. Aufgabe: Zeichenketten-Konkatenation:
        //Gegeben ist eine Liste von Zeichenketten. Konkateniere alle Zeichenketten in der Liste zu einer einzigen Zeichenkette und gebe das Ergebnis aus.

        List<String> strings = Arrays.asList("Hello", "World!", "Was", "geht", "ab?");
       StringBuilder result = new StringBuilder();
       strings.forEach(s -> result.append(STR."\{s} "));

        System.out.println(result);
        System.out.println("--------------------------------");

        //2. Aufgabe: Quadratzahlen:
        //Gegeben ist eine Liste von ganzen Zahlen. Berechnen Sie das Quadrat jeder Zahl und geben Sie die Quadratzahlen aus

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.printf("Die Quadratzahl von %d ist %d %n", n, n*n));


        System.out.println("--------------------------------");

        // 3. Länge der Zeichenketten:
        //Gegeben ist eine Liste von Zeichenketten. Gebe die Länge jeder Zeichenkette in der Liste aus.


        strings.forEach(s -> System.out.println(STR."\{s} = \{s.length()}"));




    }
}