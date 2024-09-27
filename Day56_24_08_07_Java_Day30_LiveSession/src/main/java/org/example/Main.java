package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Greet> greetList = List.of(
                new Greet("Anna Bauer", 11, true),
                new Greet("Vittorio De-Marzi", 34, false),
                new Greet("Zana Prka", 18, true),
                new Greet("Bob Baumeister", 55, false),
                new Greet("Hugo Maier", 10, false),
                new Greet("Beate Strohmeier", 7, true)
        );

        // Vornamen aller volljährigen Personen in einer Liste
        List<String> greetingListNames = greetList.stream()
                .filter(greet -> greet.getAlter() >= 18)
                .map(greet -> greet.getName().split(" ")[0])
                .collect(Collectors.toList());

        System.out.println(greetingListNames);
        System.out.println("-------------------------------------\n");
        // Grußformel für alle weiblichen Personen in die Konsole ausgeben
        greetList.stream()
                .filter(greet -> greet.isFemale())
                .forEach(greet -> System.out.println("Guten Tag," + (greet.getAlter() < 18  ? " Frau " + greet.getName().split(" ")[1] : " " + greet.getName().split(" ")[0])));
        System.out.println("-------------------------------------\n");

        // Grußformel der Ältesten Person in einer String-Variable speichern
        greetList.stream()
                .max(Comparator.comparingInt(Greet::getAlter))
                .ifPresent(greet -> System.out.println("Guten Tag, " + (greet.isFemale() ? "Frau " : "Herr ") + greet.getName().split(" ")[1] + "! Ihr Alter beträgt " + greet.getAlter() + " Jahre."));
        System.out.println("-------------------------------------\n");

        double durchschnittAlter = greetList.stream()
                .mapToInt(Greet::getAlter)
                .average()
                .orElse(0.0);
        System.out.println("Durchschnittliches Alter: " + durchschnittAlter);

        System.out.println("-------------------------------------\n");

        // Liste der Nachnamen aller Personen
        List<String> nachnamenListe = greetList.stream()
                .map(greet -> greet.getName().split(" ")[1]) // Extrahiere den Nachnamen
                .collect(Collectors.toList());

        System.out.println(nachnamenListe);

    }
}