package de.supercode;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Buch a1 = new Buch("Buch 1", "Autor 1", "12345678");
        Buch a2 = new Buch("Buch 1", "Autor 1", "87654321");
        Buch b = new Buch("Buch 2", "Autor 2", "87654321");
        Buch c = new Buch("Buch 3", "Autor 3", "987654321");

        System.out.println(a1.equals(a2)); // true
        System.out.println(a1.equals(b)); // false

        Buch.buchInRegalStellen(a1);
        Buch.buchInRegalStellen(b);
        Buch.zeigeBücherInRegal();
        Buch.buchInRegalStellen(a2);
        Buch.zeigeBücherInRegal();
        System.out.println();

        
        Buch.buchAusRegalEntnehmen(a1);
        Buch.buchAusRegalEntnehmen(b);
        Buch.zeigeBücherInRegal();

    }
}