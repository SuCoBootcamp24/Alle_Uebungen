package de.supercode;

import static de.supercode.Checker.longestUniqueSubstring;

public class Main {
    public static void main(String[] args) {
        //Gegeben ist ein String s, finde die Länge des längsten Substrings ohne sich wiederholende Zeichen.
        String s = "abcabcbb";

        String substring = longestUniqueSubstring(s);


        System.out.println("Eingabe: s =" + s);
        System.out.println("Erklärung: Die Antwort ist \"" + substring + "\", mit der länge " + substring.length() + " Zeichen.");


    }
}