import java.util.Random;

public class Rechner {
    public static void main(String[] args) {
        
        Random rand = new Random();
        Uebungsblatt[] uebungsblaetter = new Uebungsblatt[13];
        int gesamtMaxPunkte = 0;
        int gesamtErreichtePunkte = 0;

        for (int i = 0; i < 13; i++) {
            int nummer = i + 1;
            int maxPunkte = 60;
            int erreichtePunkte = rand.nextInt(61);  
            uebungsblaetter[i] = new Uebungsblatt(nummer, maxPunkte, erreichtePunkte);
            gesamtMaxPunkte += maxPunkte;
            gesamtErreichtePunkte += erreichtePunkte;
        }

        System.out.println("Gesamtzahl der maximal erreichbaren Punkte: " + gesamtMaxPunkte);
        System.out.println("Gesamtzahl der erreichten Punkte: " + gesamtErreichtePunkte);

        double prozentErreicht = (double) gesamtErreichtePunkte / gesamtMaxPunkte * 100;
        System.out.println("Prozentualer Anteil der erreichten Punkte: " + String.format("%.2f", prozentErreicht) + "%");

      
        if (prozentErreicht >= 50) {
            System.out.println("Die Klausurzulassungsgrenze von 50% wurde erreicht.");
        } else {
            System.out.println("Die Klausurzulassungsgrenze von 50% wurde nicht erreicht.");
        }


        Uebungsblatt bestes = Uebungsblatt.getBestesÜbungsblatt(uebungsblaetter);
        Uebungsblatt schlechtestes = Uebungsblatt.getSchlechtestesÜbungsblatt(uebungsblaetter);

        System.out.println("Bestes Übungsblatt: Nummer " + bestes.getNummer() + " mit " + bestes.getErreichtePunkte() + " Punkten.");
        System.out.println("Schlechtestes Übungsblatt: Nummer " + schlechtestes.getNummer() + " mit " + schlechtestes.getErreichtePunkte() + " Punkten.");
    }
}
