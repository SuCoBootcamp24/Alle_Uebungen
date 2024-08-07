package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {



        // 1. **Liste von Zahlen filtern**
        //- Gegeben: Eine Liste von ganzen Zahlen.
        //- Aufgabe: Filter alle geraden Zahlen aus der Liste.
        List<Integer> numbList = new ArrayList<>(Arrays.asList(1, 900, 5, 3, 4, 9, 3, 58745, 7, 5, 0, 6, 2, 5, 7, 10, 102,14, 15, 18, 102, 145, 974, 31458, 58745, 22458));

        List<Integer> evenNumbers = numbList.stream()
                .filter(n -> n % 2 == 0 && n != 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);

        //----------------------------------
        // 2. **Liste von Zeichenketten in Großbuchstaben umwandeln**
        //- Gegeben: Eine Liste von Zeichenketten.
        //- Aufgabe: Wandele alle Zeichenketten in der Liste in Großbuchstaben um.
        List<String> stringList = Arrays.asList("hello", "world", "java", "programming", "makes", "fun");

       List<String> upperCaseList = stringList.stream()
               .map(String::toUpperCase)
               .collect(Collectors.toList());

        System.out.println(upperCaseList);
        //----------------------------------

        //3. **Summe einer Liste von Zahlen berechnen**
        //- Gegeben: Eine Liste von ganzen Zahlen.
        //- Aufgabe: Berechne die Summe aller Zahlen in der Liste.

        int numbListSum = numbList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(numbListSum);
        //----------------------------------

        //4. **Duplikate aus einer Liste entfernen**
        //- Gegeben: Eine Liste von ganzen Zahlen mit Duplikaten.
        //- Aufgabe: Entferne alle Duplikate aus der Liste.

        List<Integer> numbListNoDuplicates = numbList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(numbListNoDuplicates);
        //----------------------------------

        //5. **Durchschnitt einer Liste von Zahlen berechnen**
        //- Gegeben: Eine Liste von ganzen Zahlen.
        //- Aufgabe: Berechne den Durchschnittswert der Zahlen in der Liste.

        double numbListAverage = numbList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.00);

        System.out.println(numbListAverage);
        //----------------------------------

        //6. **Zeichenketten nach Länge sortieren**
        //- Gegeben: Eine Liste von Zeichenketten.
        //- Aufgabe: Sortiere die Zeichenketten nach ihrer Länge.

        List<String> sortetList = stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sortetList);
        //----------------------------------


        //!!!!!!! Flatmaps !!!!!!!!

        //1. **Liste von Listen zu einer einzigen Liste “flach machen”**
        //- Gegeben: Eine Liste von Listen von ganzen Zahlen.
        //- Aufgabe: Verwende `flatMap`, um eine flache Liste zu erstellen, die alle Zahlen enthält.

        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));

        List<Integer> flatList = nestedList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(nestedList);
        System.out.println(flatList);
        //----------------------------------

        //2. **Zeichenketten in eine Liste von Wörtern aufteilen**
        //- Gegeben: Eine Liste von Sätzen (Zeichenketten).
        //- Aufgabe: Verwende `flatMap`, um eine Liste von einzelnen Wörtern zu erstellen.

        List<String> sentenceList = Arrays.asList("Hello world!", "This is a test sentence.", "Programming makes fun.");

        List<String> wordList = sentenceList.stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .collect(Collectors.toList());

        System.out.println(wordList);
        //----------------------------------

        //3. **Filtern und flach machen einer Liste von Listen**
        //- Gegeben: Eine Liste von Listen von ganzen Zahlen.
        //- Aufgabe: Filter alle Zahlen, die größer als 5 sind.

        List<List<Integer>> filteredAndFlattened = nestedList.stream()
                .map(list -> list.stream()
                        .filter(n -> n > 5)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(filteredAndFlattened);

        //ODER:

        List<Integer> filteredAndFlattened2 = nestedList.stream()
               .flatMap(list -> list.stream()
                       .filter(n -> n > 5))
               .collect(Collectors.toList());

        System.out.println(filteredAndFlattened2);
    }
}