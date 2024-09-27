
public class Kundenverwaltung {
//     **Erstellung der Klasse:**

// - Erstelle eine Klasse `Kunde`, die die Attribute `kundenId`, `name`, `email` und `telefonnummer` hat
// - Implementiere einen Konstruktor, der diese Attribute initialisiert
// - Füge Getter- und Setter-Methoden für jedes Attribut hinzu
// - Implementiere eine Methode `printDetails`, die die Details des Kunden auf der Konsole ausgibt

// **Verwendung der Klasse:**

// - erstelle eine weitere Klasse Kundenverwaltung, die eine main-Methode enthält
// - in der main-Methode sollen mindestens drei Kunden angelegt werden

// **Konstruktor:**

// - ein Konstruktor, der nur `kundenId` und `name` initialisiert, während `email` und `telefonnummer` leer sind
// - ein Konstruktor, der `kundenId`, `name` und `email` initialisiert, während `telefonnummer` leer ist
// - prüfe deine Konstruktoren, indem du weitere Kunden in der main-Methode anlegst


    public static void main(String[] args) {
        Kunde kunde1 = new Kunde("Reiner Zufall", "RZ1234");
        kunde1.printDetails();
        Kunde kunde2 = new Kunde("Max Mustermann", "MM56789");
        kunde2.printDetails();
        Kunde kunde3 = new Kunde("Mona", "Wollte", "abc@xyz.de");
        kunde3.printDetails();
        Kunde kunde4 = new Kunde("Peter", "Hatte", "kaffe@awef.de", "555-4535-123");
        kunde4.printDetails();
    }
}
