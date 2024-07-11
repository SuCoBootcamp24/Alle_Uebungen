public class Person {
    private String name;
    private boolean hasLicence;
    private int reservationCounter = 0;

    public Person(String name, boolean hasLicence) {
        this.name = name;
        this.hasLicence = hasLicence;
    }

    public String getName() {
        return this.name;
    }


    
    public boolean hasLicence() {
        return this.hasLicence;
    }

    
    public int getReservationCounter() {
        return reservationCounter;
    }

    public void setReservationCounter(int reservationCounter) {
        this.reservationCounter = reservationCounter;
    }

}
