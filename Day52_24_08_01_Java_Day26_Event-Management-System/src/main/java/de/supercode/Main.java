package de.supercode;

import de.supercode.veranstaltungen.Veranstaltung;
import de.supercode.veranstaltungen.EventManager;
import de.supercode.personen.Person;
import de.supercode.personen.Rolle;
import de.supercode.comperatoren.EventDateComparator;
import de.supercode.comperatoren.RoleComperator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Erstellung von Personen mit unterschiedlichen Rollen
        Person alice = new Person("Alice", LocalDate.of(1990, 5, 15));
        alice.setRolle(Rolle.SPEAKER);

        Person bob = new Person("Bob", LocalDate.of(1985, 8, 23));
        bob.setRolle(Rolle.STARGAST);

        Person charlie = new Person("Charlie", LocalDate.of(1995, 11, 30));
        charlie.setRolle(Rolle.VOLUNTEER);

        Person dave = new Person("Dave", LocalDate.of(1992, 2, 20));
        dave.setRolle(Rolle.ORGANIZER);

        Person eve = new Person("Eve", LocalDate.of(1988, 4, 10));
        eve.setRolle(Rolle.ZUSCHAUER);

        Person frank = new Person("Frank", LocalDate.of(1983, 6, 8));
        frank.setRolle(Rolle.SPEAKER);

        // Erstellung des EventManagers
        EventManager eventManager = new EventManager();

        // Erstellung von Veranstaltungen ohne Teilnehmerliste im Konstruktor
        Veranstaltung event1 = new Veranstaltung("Tech Conference", LocalDate.of(2024, 9, 10), 18);
        Veranstaltung event2 = new Veranstaltung("Health Summit", LocalDate.of(2024, 5, 5), 16);
        Veranstaltung event3 = new Veranstaltung("Art Expo", LocalDate.of(2024, 7, 15), 12);
        Veranstaltung event4 = new Veranstaltung("Music Festival", LocalDate.of(2024, 8, 20), 14);

        // Hinzufügen von Veranstaltungen zum EventManager
        eventManager.addEvent(event1.getDatum(), event1);
        eventManager.addEvent(event2.getDatum(), event2);
        eventManager.addEvent(event3.getDatum(), event3);
        eventManager.addEvent(event4.getDatum(), event4);

        // Hinzufügen von Teilnehmern zu den Veranstaltungen über den EventManager
        event1.addTeilnehmer(alice);
        event1.addTeilnehmer(bob);
        event1.addTeilnehmer(eve);

        event2.addTeilnehmer(charlie);
        event2.addTeilnehmer(frank);
        event2.addTeilnehmer(dave);

        event3.addTeilnehmer(alice);
        event3.addTeilnehmer(charlie);
        event3.addTeilnehmer(bob);

        event4.addTeilnehmer(frank);
        event4.addTeilnehmer(dave);
        event4.addTeilnehmer(eve);

        // Ausgabe aller Veranstaltungen an einem bestimmten Datum
        System.out.println("\nVeranstaltungen am " + LocalDate.of(2024, 9, 10) + ":");
        eventManager.getEventsByDate(LocalDate.of(2024, 9, 10));

        // Ausgabe der Teilnehmer einer bestimmten Veranstaltung
        System.out.println("\nTeilnehmer bei der Veranstaltung " + event1.getName() + ":");
        eventManager.getTeilnehmerByEvent(event1);

        // Beispiel für das Entfernen eines Teilnehmers
        eventManager.removeEventTeilnehmer(event1, alice);
        System.out.println("\nTeilnehmer bei der Veranstaltung " + event1.getName() + " nach dem Entfernen von Alice:");
        eventManager.getTeilnehmerByEvent(event1);

        // Sortierung von Veranstaltungen nach Datum mit dem EventDateComparator
        List<Veranstaltung> events = new ArrayList<>(eventManager.getEventMap().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()));
        events.sort(EventDateComparator.dateComparator);

        System.out.println("\nVeranstaltungen nach Datum sortiert:");
        events.forEach(event -> System.out.println(event.getName() + " am " + event.getDatum()));

        // Sortierung von Personen nach Rolle in der ersten Veranstaltung mit dem RoleComperator
        List<Person> participantsSortedByRole = new ArrayList<>(event1.getTeilnehmerList());
        participantsSortedByRole.sort((p1, p2) -> RoleComperator.rankComparator.compare(p1.getRolle(), p2.getRolle()));

        System.out.println("\nTeilnehmer von " + event1.getName() + " nach Rolle sortiert:");
        participantsSortedByRole.forEach(person -> System.out.println(person.getName() + " - " + person.getRolle()));
    }
}
