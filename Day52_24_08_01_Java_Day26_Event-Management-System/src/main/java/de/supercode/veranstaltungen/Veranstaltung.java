package de.supercode.veranstaltungen;

import de.supercode.personen.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Veranstaltung {
    private String name;

    private LocalDate datum;

    private int altersfreigabe;

    private List<Person> teilnehmerList;

    public Veranstaltung(String name, LocalDate datum, int altersfreigabe) {
        this.name = name;
        this.datum = datum;
        this.altersfreigabe = altersfreigabe;
        this.teilnehmerList = new ArrayList<Person>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getAltersfreigabe() {
        return altersfreigabe;
    }

    public void setAltersfreigabe(int altersfreigabe) {
        this.altersfreigabe = altersfreigabe;
    }

    public List<Person> getTeilnehmerList() {
        return teilnehmerList;
    }

    public void setTeilnehmerList(List<Person> teilnehmerList) {
        this.teilnehmerList = teilnehmerList;
    }

    //-----

    public void addTeilnehmer(Person teilnehmer) {
        if (!teilnehmerList.contains(teilnehmer)) teilnehmerList.add(teilnehmer);
        else System.out.println("Teilnehmer bereits vorhanden.");
    }
}
