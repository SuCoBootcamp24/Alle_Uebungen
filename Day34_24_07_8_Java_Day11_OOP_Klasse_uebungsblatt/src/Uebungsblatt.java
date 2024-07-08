public class Uebungsblatt {
    private int nummer;
    private int maxPunkte;
    private int erreichtePunkte;

    public Uebungsblatt(int nummer, int maxPunkte, int erreichtePunkte) {
        this.nummer = nummer;
        this.maxPunkte = maxPunkte;
        this.erreichtePunkte = erreichtePunkte;
    }

  //-------------
    

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getMaxPunkte() {
        return maxPunkte;
    }

    public void setMaxPunkte(int maxPunkte) {
        this.maxPunkte = maxPunkte;
    }

    public int getErreichtePunkte() {
        return erreichtePunkte;
    }

    public void setErreichtePunkte(int erreichtePunkte) {
        this.erreichtePunkte = erreichtePunkte;
    }


    //-------------

    public static Uebungsblatt getBestesÜbungsblatt(Uebungsblatt[] uebungsblaetter) {
        Uebungsblatt bestes = uebungsblaetter[0];
        for (Uebungsblatt u : uebungsblaetter) {
            if (u.getErreichtePunkte() > bestes.getErreichtePunkte()) {
                bestes = u;
            }
        }
        return bestes;
    }

   
    public static Uebungsblatt getSchlechtestesÜbungsblatt(Uebungsblatt[] uebungsblaetter) {
        Uebungsblatt schlechtestes = uebungsblaetter[0];
        for (Uebungsblatt u : uebungsblaetter) {
            if (u.getErreichtePunkte() < schlechtestes.getErreichtePunkte()) {
                schlechtestes = u;
            }
        }
        return schlechtestes;
    }
}
