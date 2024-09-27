package device;

import interfaces.Bluetoothfaehig;

public class Fernseher extends Geraet implements Bluetoothfaehig {

    private int bildschirmgroese;


    public Fernseher(String marke, String modell, int bildschirmgroesse) {
        super(marke, modell);
        this.bildschirmgroese = bildschirmgroesse;

    }

    //---
    public int getBildschirmgroese() {
        return bildschirmgroese;
    }

    public void setBildschirmgroese(int bildschirmgroese) {
        this.bildschirmgroese = bildschirmgroese;
    }

    //----
    @Override
    public void anzeigen() {
        super.anzeigen();
        System.out.println("Fernseher Bildschirmgroesse: " + bildschirmgroese + "\"");
    }

    @Override
    public void verbindenMitBluetooth() {
        System.out.println("Verbinde mit Bluetooth...");
    }
}
