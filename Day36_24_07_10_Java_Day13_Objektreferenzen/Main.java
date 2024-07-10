import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    /*
        Position p1 = new Position(11, 21);
        Position p2 = new Position(11, 21);

        if (p1 == p2) {
		    System.out.println("true");
        } else {
            System.out.println("false");
        }
        
    Die Ausgabe ist false. Java vergleicht mit dem ""=="" Operator bei Objekten die Referenzen, nicht den Inhalt der Objekte. 
        ---------------------------------
        
        Position p1 = new Position(0, 0);
        Position p2 = new Position(0, 0);
        p1 = p2;
        p1.x = 21;
        p2.y = 11;
        p2 = p1;
        System.out.println("p1 -> X: " + p2.x + ", Y: " + p2.y);

    Die Ausgabe ist p1 -> X: 21, Y: 11. 
    weil:
    1. p1 und p2 zeigen zunächst auf zwei verschiedene Instanzen der Klasse Position.
    2. p1 = p2; macht, dass p1 jetzt auf das gleiche Objekt zeigt wie p2.
    3. p1.x = 21; ändert den Wert des x-Feldes des Objekts, auf das beide Referenzen (p1 und p2) zeigen.
    4. p2.y = 11; ändert den Wert des y-Feldes desselben Objekts.
    5. p2 = p1; ändert nichts, da p1 und p2 bereits auf dasselbe Objekt zeigen.
    6. Da p1 und p2 auf dasselbe Objekt zeigen, hat dieses Objekt die Werte x = 21 und y = 11.
        --------------------------------

        Position p1 = new Position(3, 3);
        Position p2 = new Position(6, 6);
        Position p3 = p1;

        p1 = p2;
        p2 = new Position(9, 9);
        p3.y = 12;

        System.out.println("p1 -> X: " + p1.x + ", Y: " + p1.y);
        System.out.println("p2 -> X: " + p2.x + ", Y: " + p2.y);
        System.out.println("p3 -> X: " + p3.x + ", Y: " + p3.y);

    Die Ausgaben sind:  p1 -> X: 6, Y: 6
                        p2 -> X: 9, Y: 9
                        p3 -> X: 3, Y: 12
    Warum?

    1. Position p1 = new Position(3, 3); erstellt ein Objekt p1 mit x = 3 und y = 3.
    2. Position p2 = new Position(6, 6); erstellt ein Objekt p2 mit x = 6 und y = 6.
    3. Position p3 = p1; macht, dass p3 auf dasselbe Objekt zeigt wie p1.
        
    
    */

    }
}
