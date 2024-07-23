package device;

import interfaces.Bluetoothfaehig;
import interfaces.Internetfaehig;

import java.sql.SQLOutput;

public class Smartphone extends Geraet implements Internetfaehig, Bluetoothfaehig {

    private String betriebssystem;

    public Smartphone(String marke, String modell, String betriebssystem) {
        super(marke, modell);
        this.betriebssystem = betriebssystem;
    }

    public String getBetriebssystem() {
        return betriebssystem;
    }

    public void setBetriebssystem(String betriebssystem) {
        this.betriebssystem = betriebssystem;
    }


    //----

    @Override
    public void anzeigen() {
        System.out.println("Smartphone-Details:");
        System.out.printf("Smartphone %s %s, Betriebssystem: %s%n", getMarke(), getModell(), betriebssystem);
    }

    @Override
    public void verbindenMitBluetooth() {
        System.out.println("Verbinde mit Bluetooth...");
    }

    @Override
    public void verbindenMitInternet() {
        System.out.println("Verbinde mit Internet...");
    }
}
