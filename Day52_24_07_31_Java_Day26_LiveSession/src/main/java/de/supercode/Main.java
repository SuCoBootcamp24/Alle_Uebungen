package de.supercode;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> namelist = new HashSet<>();

        System.out.println("Willkommen beim SuperCode-Namebot!");

        while (true) {
            System.out.println("Bitte gebe einen Namen, \"LISTE\" (Zur Ausgabe aller Namen) oder zum Beenden \"ENDE\" ein:");
            String userInput = scanner.nextLine();

            if (userInput.equals("LISTE")) {
                if (namelist.isEmpty()) {
                    System.out.println("Keine Namen in der Liste.");
                } else {
                    System.out.println("Namen in der Liste:");
                    for (String name : namelist) {
                        System.out.println(name);
                    }
                }
            } else if (userInput.equals("ENDE")) {
                break;
            } else {
                if (!namelist.contains(userInput)) {
                    namelist.add(userInput);
                    System.out.println("Gespeichert!");
                } else {
                    System.out.println("Dieser Name ist bereits vergeben.");
                }
            }
        }

        System.out.println("Auf Wiedersehen!");
        scanner.close();
    }
}
