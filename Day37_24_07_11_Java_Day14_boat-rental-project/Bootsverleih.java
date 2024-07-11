import java.util.ArrayList;

public class Bootsverleih {
    private ArrayList<Boot> boote;
    private ArrayList<Person> kunden;
    // private double umsatz;

    public Bootsverleih () {}

    //--------
    public ArrayList<Boot> getBoote() {
        return boote;
    }

    public void addBoot(Boot boot) {
        this.boote.add(boot);
    }

    public void removeBoot(Boot boot) {
      if(this.boote.contains(boot)) boote.remove(boot);
    }

    
    public ArrayList<Person> getKunden() {
        return kunden;
    }

    public void setKunden(ArrayList<Person> kunden) {
        this.kunden = kunden;
    }



    // the customer with the most reservation (count)
    public Person topCustomer() {
        int mostReservation = 0;
        Person topCosumer = null;
        for (Person p : kunden) {
            if (p.getReservationCounter() > mostReservation) {
                topCosumer = p;
                mostReservation = p.getReservationCounter();
            }
        }

        
    return topCosumer;
    }

    
}
