import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bankkonto {

    private static HashMap<String, Bankkonto> bestandsKonten = new HashMap<>();


    private String kontoinhaber;
    private String kontonummer;
    private double kontostand;
    private ArrayList<String> ktnAktivitaet = new ArrayList<>();

      public Bankkonto(String kontoinhaber, String kontonummer) {
        this.kontoinhaber = kontoinhaber;
        this.kontonummer = kontonummer;
        this.kontostand = 0.0f;
        LocalDateTime currentDateTime = LocalDateTime.now();
        ktnAktivitaet.add(currentDateTime + "  ERSTELLT          Bankinhaber: " + this.kontoinhaber + "  Kontonummer: " + this.kontonummer + "   Gesamt: " +  this.kontostand + " €");

        bestandsKonten.put(kontonummer, this);
    }

    // -------------
    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

   // __  
    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }


    // __  
    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    // --------

    public boolean einzahlen(double betrag) {
        if (betrag > 0) {
            setKontostand(getKontostand() + betrag);
            LocalDateTime currentDateTime = LocalDateTime.now();
            ktnAktivitaet.add(currentDateTime + "  EINZAHLUNG        Betrag: +" + betrag + "  Gesamt: " +  this.kontostand + " €");
            return true;
        }
        return false;
    }


    public boolean abheben( double betrag) {
        if (getKontostand() - betrag >= 0) {
            setKontostand(getKontostand() - betrag);
            LocalDateTime currentDateTime = LocalDateTime.now();
            ktnAktivitaet.add(currentDateTime + "  AUSZAHLUNG        Betrag: -" + betrag + "  Gesamt: " +  this.kontostand + " €");
            return true;
        }
        return false;
    }

    public void getKontoinformationen() {
        System.out.println("Kontoinhaber: " + getKontoinhaber());
        System.out.println("Kontonummer: " + getKontonummer());
        System.out.println("Kontostand: " + getKontostand());
    }

    public boolean ueberweisen(String empfaengerKtnNr, double betrag) {
       
        if (empfaengerKtnNr != null) {
            Bankkonto empfaenger = kontoSuche(empfaengerKtnNr);
            if (empfaenger == null) return false;
            if (getKontostand() - betrag >= 0) {
                setKontostand(getKontostand() - betrag);
                empfaenger.empfangen(this, betrag);
                LocalDateTime currentDateTime = LocalDateTime.now();
                ktnAktivitaet.add(currentDateTime + "  UEBERWEISUNG      Empfaenger: " + empfaenger.getKontoinhaber() + " " + empfaenger.kontonummer + "      Betrag: -" + betrag + "  Gesamt: " +  this.kontostand + " €");
                return true;
            }
        }
        return false;
    }

    public void empfangen(Bankkonto sender, double betrag){
        if (betrag > 0) setKontostand(getKontostand() + betrag);
        LocalDateTime currentDateTime = LocalDateTime.now();
        ktnAktivitaet.add(currentDateTime + "  ERHALTEN          Sender: " + sender.getKontoinhaber() + " " + sender.kontonummer + "      Betrag: +" + betrag + "  Gesamt: " +  this.kontostand + " €");
        
    }

    public void kontoauszug() {
        for(int i = 0; i < ktnAktivitaet.size(); i++) {
            System.out.println(ktnAktivitaet.get(i));
        }
    }

    //--------------------


    public static void alleKonten() {
        System.out.println("Anzahl der Konten: " + bestandsKonten.size());
        for (Map.Entry<String,Bankkonto> ktn : bestandsKonten.entrySet()) {
            Bankkonto ktnData = ktn.getValue();
            System.out.println(ktnData.kontonummer + "   " + ktnData.kontoinhaber);
        }
    }


    public Bankkonto kontoSuche(String empfaengeString) {

        for (Map.Entry<String,Bankkonto> ktn : bestandsKonten.entrySet()) {
            if (ktn.getKey().equals(empfaengeString)) {
                return ktn.getValue();
            }
        }
        return null;
    }


}