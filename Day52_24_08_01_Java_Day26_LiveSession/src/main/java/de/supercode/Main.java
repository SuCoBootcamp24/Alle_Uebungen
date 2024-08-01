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

            // Überprüfung, ob die Eingabe nur Buchstaben enthält
            if (!userInput.matches("[a-zA-ZäöüÄÖÜß]+") && !userInput.equals("LISTE") && !userInput.equals("ENDE")) {
                System.out.println("Bitte gebe nur gültige Namen ohne Zahlen ein.");
                continue;
            }

            if (userInput.equals("LISTE")) {
                System.out.println(namelist.isEmpty() ? "Keine Namen in der Liste." : STR."Namen in der Liste:\n\{String.join("\n", namelist)}");
            } else if (userInput.equals("ENDE")) {
                break;
            } else {
                System.out.println(namelist.add(userInput) ? "Gespeichert!" : "Dieser Name ist bereits vergeben.");
            }
        }

        System.out.println("Auf Wiedersehen!");
        scanner.close();
    }
}
