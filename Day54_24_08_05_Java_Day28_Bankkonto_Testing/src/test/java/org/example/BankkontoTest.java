package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankkontoTest {

    @Test
    void getKontonummer() {
        double expectedSaldo = 500.50;
        Bankkonto konto = new Bankkonto("Reiner Zufall", "123456789", expectedSaldo);

        assertEquals(expectedSaldo, konto.getSaldo());
    }

    @Test
    void getKontostand() {
        String expectedKtnNr = "123456789";
        Bankkonto konto = new Bankkonto("Reiner Zufall", expectedKtnNr, 0.0);

        assertEquals(expectedKtnNr, konto.getKontonummer());
    }

    @Test
    void ErfolgreichesEinzahlenAufDasKonto() {
        double einzahlBetrag = 650.00;
        Bankkonto konto = new Bankkonto("Reiner Zufall", "123456789", 0);

        konto.einzahlen(einzahlBetrag);

        assertEquals(einzahlBetrag, konto.getSaldo());
    }

    @Test
    void NegativBetragEinzahlenAufDasKonto() {
        double einzahlBetrag = -50.00;
        Bankkonto konto = new Bankkonto("Reiner Zufall", "123456789", 0);

        assertThrows(IllegalArgumentException.class, () -> {konto.einzahlen(einzahlBetrag);});
    }





    @Test
    void ErfolgreichesAbhebenAufDasKonto() {
        double auszahlBetrag = 60.00;
        double startSaldo = 61.00;
        Bankkonto konto = new Bankkonto("Max Mustermann", "987456321", startSaldo);

        konto.abheben(auszahlBetrag);

        assertEquals(startSaldo - auszahlBetrag, konto.getSaldo());
    }

    @Test
    void FehlerhaftesAbhebenAufDasKonto() {
        double auszahlBetrag = 65.00;
        double startSaldo = 61.00;
        Bankkonto konto = new Bankkonto("Max Mustermann", "987456321", startSaldo);

        assertThrows(IllegalArgumentException.class, () -> {konto.abheben(auszahlBetrag);});
        assertThrows(IllegalArgumentException.class, () -> {konto.abheben(startSaldo);});
    }




    @Test
    void erfolgreicheUeberweisen() {
        double ueberweisenBetrag = 50.00;
        double startSaldoKonto1 = 60.00;
        double startSaldoKonto2 = 31.00;
        Bankkonto konto1 = new Bankkonto("Max Mustermann", "987456321", startSaldoKonto1);
        Bankkonto konto2 = new Bankkonto("Reiner Zufall", "123456789", startSaldoKonto2);

        konto1.ueberweisen(konto2.getKontonummer(), ueberweisenBetrag);

        assertEquals(startSaldoKonto1 - ueberweisenBetrag, konto1.getSaldo());
        assertEquals(startSaldoKonto2 + ueberweisenBetrag, konto2.getSaldo());
    }


    @Test
    void FehlerhafteUeberweisen() {
        double ueberweisenBetrag = 70.00;
        double startSaldoKonto1 = 60.00;
        double startSaldoKonto2 = 31.00;
        Bankkonto konto1 = new Bankkonto("Max Mustermann", "987456321", startSaldoKonto1);
        Bankkonto konto2 = new Bankkonto("Reiner Zufall", "123456789", startSaldoKonto2);

        assertThrows(IllegalArgumentException.class, () -> {konto1.ueberweisen(konto2.getKontonummer(), ueberweisenBetrag);});
    }

    @Test
    void UeberweisenAnNichtExistierendesKonto() {
        double ueberweisenBetrag = 30.00;
        double startSaldoKonto1 = 60.00;
        Bankkonto konto1 = new Bankkonto("Max Mustermann", "987456321", startSaldoKonto1);

        assertThrows(IllegalArgumentException.class, () -> {konto1.ueberweisen("unbekannt", ueberweisenBetrag);});
    }

    @Test
    void UeberweisenAnNULLKonto() {
        double ueberweisenBetrag = 30.00;
        double startSaldoKonto1 = 60.00;
        Bankkonto konto1 = new Bankkonto("Max Mustermann", "987456321", startSaldoKonto1);

        assertThrows(IllegalArgumentException.class, () -> {konto1.ueberweisen(null, ueberweisenBetrag);});
    }
}