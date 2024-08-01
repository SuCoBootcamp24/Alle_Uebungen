package de.supercode;

import java.util.Scanner;

public class UserInput {


    public static String getUserInput(Scanner scanner) {
        System.out.println("Bitte gebe einen Namen, \"LISTE\" (Zur Ausgabe aller Namen) oder zum beenden \"ENDE\" ein:");
        return scanner.nextLine();
    }

}
