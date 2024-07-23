package device;

public class Geraet {
    private String marke;
    private String modell;

    private boolean istEingeschaltet = false;

    public Geraet(String marke, String modell) {
        this.marke = marke;
        this.modell = modell;
    }

    //-----
    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public boolean isIstEingeschaltet() {
        return istEingeschaltet;
    }

    public void setIstEingeschaltet(boolean istEingeschaltet) {
        this.istEingeschaltet = istEingeschaltet;
    }

    //---------
    public void einschalten(){
        System.out.println("Gerät wird eingeschaltet.....");
        setIstEingeschaltet(true);
    }

    public void ausschalten(){
        System.out.println("Gerät wird ausgeschaltet.....");
        setIstEingeschaltet(false);
    }

    public void anzeigen(){
        System.out.printf("Gerät: %s %s%n", getMarke(), getModell());
    }


}
