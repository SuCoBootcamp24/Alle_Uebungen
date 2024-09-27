
public class Kundenverwaltung {
    // ### Klasse Buch erstellen:

    // - Erstelle eine Klasse `Buch`, die die Attribute `titel`, `autor`, `isbn` und `seitenzahl` hat
    // - Implementiere einen Konstruktor, der diese Attribute initialisiert
    // - Füge Getter- und Setter-Methoden für jedes Attribut hinzu
    // - Implementiere eine Methode `druckeDetails`, die die Details des Buches auf der Konsole ausgibt
    
    // ### Klasse Buch verwenden:
    
    // - erstelle eine weitere Klasse, die eine main Methode enthält
    // - in der `main`Methode sollen mindestens fünf `Buch`Objekte erstellt und in einem Array abgelegt werden
    // - rufe für jedes Buch die Methode `druckeDetails` auf, um die Buchdetails auf der Konsole auszugeben
    
    // ### ✨ Bonus ✨ → Suchfunktion
    
    // - Implementiere eine Methode `sucheNachISBN` in der Klasse `Buch`, die ein Array von Büchern übergeben bekommt und ein Buch anhand seiner ISBN sucht und zurückgibt.

    public static void main(String[] args) {

        Buch buch1 = new Buch("Titel", "Autor", "S234 567 87", 156);
        buch1.druckeDetails();
        Buch buch2 = new Buch("Titel2", "Autor2", "S212 234 42", 200);
        buch2.druckeDetails();
        Buch buch3 = new Buch("Titel3", "Autor3", "S12 245 21", 10);
        buch3.druckeDetails();

        Buch gefundenesBuch = Buch.sucheNachISBN("S212 234 42");
        if (gefundenesBuch != null) {
            gefundenesBuch.druckeDetails();
        } else {
            System.out.println("Buch nicht gefunden.");
        }
    }
}
