package de.supercode.veranstaltungen;

import de.supercode.personen.Rolle;
import de.supercode.personen.Person;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class EventManager {

    HashMap<LocalDate, List<Veranstaltung>> eventMap = new HashMap<>();

    HashMap<Veranstaltung, HashMap<String, Set<GroupLayout.Group>>> TeilnehmerVerwByEvent = new HashMap<>();

    public EventManager() {
        this.eventMap = new HashMap<>();
        this.TeilnehmerVerwByEvent = new HashMap<>();
    }


    public void addEvent(LocalDate date, Veranstaltung event) {

    }

    public void addEventTeilnehmer(Veranstaltung event, Rolle rolle) {

    }

    public void removeEventTeilnehmer(Veranstaltung event, Person teilnehmer) {

    }

    public void getTeilnehmerByEvent(Veranstaltung event) {

    }

    public void getEventsByDate(LocalDate date) {

    }




}
