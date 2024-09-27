package de.supercode.comperatoren;

import de.supercode.veranstaltungen.Veranstaltung;

import java.util.Comparator;

public class EventDateComparator {

    public static Comparator<Veranstaltung> dateComparator = Comparator.comparing(Veranstaltung::getDatum);
}
