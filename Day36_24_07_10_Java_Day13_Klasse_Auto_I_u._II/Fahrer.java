public class Fahrer {
    private String vorname;
    private String nachname;
    private byte alter;


    public Fahrer(String vorname, String nachname, byte alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }


    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }



    public byte getAlter() {
        return alter;
    }

    public void setAlter(byte alter) {
        this.alter = alter;
    }

    //-------------


    public void fahren(Auto auto, double kilometer) {
        if (getAlter() >= 18) {
            //if(auto exist) else Eception
            if(kilometer > 0) {
              if ((auto.getTankinhalt() - ((auto.getVerbrauch() / 100) * kilometer)) >= 0) {
                auto.setKmStand(auto.getKmStand() + kilometer);
                System.out.println("bruuuummmm");
                auto.setTankinhalt(auto.getTankinhalt() - ((auto.getVerbrauch() / 100) * kilometer));
                } else System.out.println("Auto Springt nicht an. Tank ist Leer");
            } else {
                throw new IllegalArgumentException("Kilometer dürfen nicht negativ sein");
            }
        } else {
            System.out.println("Fahrer ist unter 18J");
        }
    }

   

}



