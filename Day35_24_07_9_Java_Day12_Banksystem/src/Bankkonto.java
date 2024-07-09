public class Bankkonto {

    private String kontoinhaber;
    private String kontonummer;
    private double kontostand;

    public Bankkonto(String kontoinhaber, String kontonummer) {
        this.kontoinhaber = kontoinhaber;
        this.kontonummer = kontonummer;
        this.kontostand = 0.0f;
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
            this.kontostand += betrag;
            return true;
        }
        return false;
    }


    public boolean abheben( double betrag) {
        if (kontostand - betrag > 0) {
            kontostand -= betrag;
            return true;
        }
        return false;
    }

    public void getKontoinformationen() {
        System.out.println("Kontoinhaber: " + this.kontoinhaber);
        System.out.println("Kontonummer: " + this.kontonummer);
        System.out.println("Kontostand: " + this.kontostand);
    }
}