public class Auto {
    
    private final double SERVICEINTERVAL = 15000.0f;

    private String marke;
    private String model;
    private int baujahr;
    private double kmStand = 0.0f;
    private double tankkapazitaet = 50.0f;
    private double tankinhalt = 0.0f;
    private double verbrauch = 7;
    private double lastService = 0;


    public Auto(String marke, String model, int baujahr) {
        this.marke = marke;
        this.model = model;
        this.baujahr = baujahr;

    }

    //--------
    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    
    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }


    public double getKmStand() {
        return kmStand;
    }

    public void setKmStand(double kmStand) {
        this.kmStand = kmStand;
    }


    public double getTankkapazitaet() {
        return tankkapazitaet;
    }

    public void setTankkapazitaet(double tankkapazitaet) {
        this.tankkapazitaet = tankkapazitaet;
    }


    public double getTankinhalt() {
        return tankinhalt;
    }

    public void setTankinhalt(double tankinhalt) {
        this.tankinhalt = tankinhalt;
    }


    public double getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }


    public double getLastService() {
        return lastService;
    }

    public void setLastService(double lastService) {
        this.lastService = lastService;
    }
    
    //--------

    public void getDetails() {
        System.out.println("Marke: " + getMarke() + "\nBaujahr: " + getBaujahr() + "\nKilometerstand: " + getKmStand() + "\n");
    }

    public void tanken(double liter) {
        if (getTankinhalt() + liter <= getTankkapazitaet()) {
            setTankinhalt(getTankinhalt() + liter);
            System.out.println(getTankinhalt());
        } else {
            System.out.println("Tank würde über laufen!!!");
        }
    }

    public void pruefeService() {
        if (getKmStand() < (getLastService() + SERVICEINTERVAL)) {
            System.out.println("Service OK");
        } else System.out.println("Service ist fällig!!");
    }

    public void serviceDurchfueren(){
        setLastService(getKmStand());
    }

    public double reichweiteBerechnen(){

        return Math.round(getTankinhalt() /  (getVerbrauch() / 100));
    }
}


