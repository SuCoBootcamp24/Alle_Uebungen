package de.supercode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Buch {

    private static final HashMap<Buch, Integer> BUCH_REGAL = new HashMap<>();

    private String titel;

    private String autor;

    private String isbn;


    public Buch(String titel, String autor, String isbn) {
        this.titel = titel;
        this.autor = autor;
        this.isbn = isbn;
    }

    //----
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static HashMap<Buch, Integer> getBUCH_REGAL() {
        return BUCH_REGAL;
    }


//---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buch buch = (Buch) o;
        return Objects.equals(titel, buch.titel) && Objects.equals(autor, buch.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, autor);
    }


    //----
    public static void buchInRegalStellen(Buch buch) {
        if (BUCH_REGAL.containsKey(buch)) BUCH_REGAL.put(buch, BUCH_REGAL.get(buch) + 1);
        else BUCH_REGAL.put(buch, 1);
    }

    public static void zeigeBücherInRegal() {
        System.out.println("Buchregal:");
        for (Map.Entry<Buch, Integer> buch : BUCH_REGAL.entrySet()) {
            System.out.println("\tBuch: " + buch.getKey().getTitel() + ", Anzahl: " + buch.getValue() + " Stück"  );
        }
    }

    public  static void buchAusRegalEntnehmen(Buch buch) {
        if (BUCH_REGAL.containsKey(buch) && BUCH_REGAL.get(buch) > 0) {
            if (BUCH_REGAL.get(buch) == 1) BUCH_REGAL.remove(buch);
            else BUCH_REGAL.put(buch, BUCH_REGAL.get(buch) - 1);
        } else {
            System.out.println("Es gibt keine Bücher mehr in diesem Regal.");
        }
    }



}
