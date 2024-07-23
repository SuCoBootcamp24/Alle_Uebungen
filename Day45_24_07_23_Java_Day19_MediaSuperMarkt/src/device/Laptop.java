package device;

import interfaces.Internetfaehig;

public class Laptop extends Geraet implements Internetfaehig {

    private String prozessor;


    public Laptop(String marke, String modell, String prozessor) {
        super(marke, modell);
        this.prozessor = prozessor;
    }

    public String getProzessor() {
        return prozessor;
    }

    public void setProzessor(String prozessor) {
        this.prozessor = prozessor;
    }

    //----
    @Override
    public void anzeigen() {
        System.out.println("Smartphone-Details:");
        System.out.printf("Smartphone %s %s, Betriebssystem: %s%n", getMarke(), getModell(), getProzessor());
    }

    @Override
    public void verbindenMitInternet() {
        System.out.println("Verbinde mit Internet...");
    }
}
