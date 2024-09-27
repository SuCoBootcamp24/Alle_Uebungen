package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bankkonto {

    private static HashMap<String, Bankkonto> bestandsKonten = new HashMap<>();


    private String kontoinhaber;
    private String kontonummer;
    private double saldo;
    private ArrayList<String> ktnAktivitaet = new ArrayList<>();

    public Bankkonto(String kontoinhaber, String kontonummer, double startSaldo) {
        this.kontoinhaber = kontoinhaber;
        this.kontonummer = kontonummer;
        this.saldo = startSaldo;
        LocalDateTime currentDateTime = LocalDateTime.now();
        ktnAktivitaet.add(currentDateTime + "  ERSTELLT          Bankinhaber: " + this.kontoinhaber + "  Kontonummer: " + this.kontonummer + "   Gesamt: " +  this.saldo + " €");

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
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // --------

    public void einzahlen(double betrag) {
        if (betrag <= 0) throw new IllegalArgumentException("Betrag ist kleiner Gleich 0€");

            setSaldo(getSaldo() + betrag);
            LocalDateTime currentDateTime = LocalDateTime.now();
            ktnAktivitaet.add(currentDateTime + "  EINZAHLUNG        Betrag: +" + betrag + "  Gesamt: " +  this.saldo + " €");

    }


    public void abheben(double betrag) {
        if (getSaldo() - betrag <= 0) throw new IllegalArgumentException("Saldo deckt betrag nicht ab!");

            setSaldo(getSaldo() - betrag);
            LocalDateTime currentDateTime = LocalDateTime.now();
            ktnAktivitaet.add(currentDateTime + "  AUSZAHLUNG        Betrag: -" + betrag + "  Gesamt: " +  this.saldo + " €");

    }

    public void getKontoinformationen() {
        System.out.println("Kontoinhaber: " + getKontoinhaber());
        System.out.println("Kontonummer: " + getKontonummer());
        System.out.println("Kontostand: " + getSaldo());
    }

    public void ueberweisen(String empfaengerKtnNr, double betrag) {

        if (empfaengerKtnNr == null) throw new IllegalArgumentException("Konto nocht definiert");

        Bankkonto empfaenger = kontoSuche(empfaengerKtnNr);

        if (empfaenger == null) throw new IllegalArgumentException("Konto Existiert nicht");
        if (getSaldo() - betrag <= 0) throw new IllegalArgumentException("Konto ist nicht ausreichend gedeckt");

        setSaldo(getSaldo() - betrag);
        empfaenger.empfangen(this, betrag);
        LocalDateTime currentDateTime = LocalDateTime.now();
        ktnAktivitaet.add(currentDateTime + "  UEBERWEISUNG      Empfaenger: " + empfaenger.getKontoinhaber() + " " + empfaenger.kontonummer + "      Betrag: -" + betrag + "  Gesamt: " +  this.saldo + " €");

    }


    public void empfangen(Bankkonto sender, double betrag){
        if (betrag > 0) setSaldo(getSaldo() + betrag);
        LocalDateTime currentDateTime = LocalDateTime.now();
        ktnAktivitaet.add(currentDateTime + "  ERHALTEN          Sender: " + sender.getKontoinhaber() + " " + sender.kontonummer + "      Betrag: +" + betrag + "  Gesamt: " +  this.saldo + " €");

    }

    public void kontoauszug() {
        System.out.println("Kontoinhaber: " + this.kontoinhaber + ", Kontonnr.: " + this.kontonummer);
        for(int i = 0; i < ktnAktivitaet.size(); i++) {
            System.out.println(ktnAktivitaet.get(i));
        }
        System.out.println();
        getSaldo();
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