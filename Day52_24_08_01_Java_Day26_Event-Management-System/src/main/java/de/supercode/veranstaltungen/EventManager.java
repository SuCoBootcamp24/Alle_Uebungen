package de.supercode.veranstaltungen;

import de.supercode.personen.Person;
import de.supercode.personen.Rolle;

import java.time.LocalDate;
import java.util.*;

public class EventManager {

    private HashMap<LocalDate, List<Veranstaltung>> eventMap;
    private HashMap<Veranstaltung, HashMap<String, Set<Rolle>>> teilnehmerVerwByEvent;

    public EventManager() {
        this.eventMap = new HashMap<>();
        this.teilnehmerVerwByEvent = new HashMap<>();
    }

    public void addEvent(LocalDate date, Veranstaltung event) {
        eventMap.computeIfAbsent(date, k -> new ArrayList<>()).add(event);
        teilnehmerVerwByEvent.putIfAbsent(event, new HashMap<>());
    }

    public void addEventTeilnehmer(Veranstaltung event, Rolle rolle) {
        teilnehmerVerwByEvent.computeIfAbsent(event, k -> new HashMap<>())
                .computeIfAbsent(rolle.name(), k -> new HashSet<>());
    }

    public void removeEventTeilnehmer(Veranstaltung event, Person teilnehmer) {
        HashMap<String, Set<Rolle>> rollenMap = teilnehmerVerwByEvent.get(event);
        if (rollenMap != null) {
            rollenMap.values().forEach(rollenSet -> rollenSet.remove(teilnehmer.getRolle()));
            if (rollenMap.values().stream().allMatch(Set::isEmpty)) {
                teilnehmerVerwByEvent.remove(event);
            }
        }
    }

    public void getTeilnehmerByEvent(Veranstaltung event) {
        HashMap<String, Set<Rolle>> rollenMap = teilnehmerVerwByEvent.get(event);
        if (rollenMap != null) {
            System.out.println(STR."Teilnehmer der Veranstaltung '\{event.getName()}':");
            rollenMap.forEach((rolle, personenSet) -> {
                System.out.println(STR."Rolle: \{rolle}");
                personenSet.forEach(System.out::println);
            });
        } else {
            System.out.println(STR."Keine Teilnehmer gefunden für die Veranstaltung '\{event.getName()}'.");
        }
    }

    public void getEventsByDate(LocalDate date) {
        List<Veranstaltung> events = eventMap.get(date);
        if (events != null && !events.isEmpty()) {
            System.out.println(STR."Veranstaltungen am \{date}:");
            events.forEach(event -> System.out.println(event.getName()));
        } else {
            System.out.println(STR."Keine Veranstaltungen am \{date} gefunden.");
        }
    }
}
