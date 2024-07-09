import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bankkonto {

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

    }

    // -------------
    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }


    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }


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

    public boolean ueberweisen(Bankkonto empfaenger, double betrag) {
        if (getKontostand() - betrag >= 0) {
            setKontostand(getKontostand() - betrag);
            empfaenger.empfangen(this, betrag);
            LocalDateTime currentDateTime = LocalDateTime.now();
            ktnAktivitaet.add(currentDateTime + "  UEBERWEISUNG      Empfaenger: " + empfaenger.getKontoinhaber() + " " + empfaenger.kontonummer + "      Betrag: -" + betrag + "  Gesamt: " +  this.kontostand + " €");
            return true;
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


}