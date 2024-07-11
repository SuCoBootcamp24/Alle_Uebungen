import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    
    public static void main(String[] args) {
        Boot boot1 = new Boot("Segelboot", 4, false, 20);
        Boot boot2 = new Boot("Motorboot", 4, false, 36);
        Boot boot3 = new Boot("Motorboot", 2, true, 28);
        Boot boot4 = new Boot("Segelboot", 16, true, 92);
        Boot boot5 = new Boot("Segelboot", 2, false, 16);

        Person andreas = new Person("Andreas", true);
        Person anton = new Person("Anton", true);
        Person peter = new Person("Peter", false);

        LocalDateTime sonnabend12 = LocalDateTime.of(2024, Month.JULY, 13, 12, 0);
        LocalDateTime sonntag11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 0);
        LocalDateTime sonntagNach11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 1);
        LocalDateTime montag12 = LocalDateTime.of(2024, Month.JULY, 15, 12, 0);
        
        // boot3.addReservation(sonnabend12, sonntag11, peter); // Licence required!

        boot3.addReservation(sonnabend12, sonntag11, andreas);

        boot3.addReservation(sonntagNach11, montag12, anton);

        boot3.printReservations();

        

    }
}
