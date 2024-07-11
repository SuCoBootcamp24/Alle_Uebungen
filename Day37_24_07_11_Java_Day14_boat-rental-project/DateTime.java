import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static void main(String[] args) {
        
        LocalDateTime jetzt = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd | MM | yyyy |-| HH | mm ");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("E dd.MMM HH:mm");

        System.out.println(jetzt.format(format1));
        System.out.println(jetzt.format(format2));

        LocalDateTime andereZeit = LocalDateTime.now();
        Period diff = Period.between(jetzt.toLocalDate(), andereZeit.toLocalDate());
        System.out.println(diff.getDays());

        Duration duration = Duration.between(jetzt, andereZeit);
        System.out.println(duration.getNano());
        
        System.out.println(jetzt.compareTo(andereZeit));
        System.out.println(jetzt.compareTo(jetzt));
        System.out.println(andereZeit.compareTo(jetzt));

        System.out.println(jetzt.isBefore(andereZeit));
        System.out.println(jetzt.isAfter(andereZeit));
        System.out.println(jetzt.isAfter(jetzt));
        System.out.println(jetzt.isBefore(jetzt));
        
        LocalDateTime kursbeginn = LocalDateTime.of(2024, Month.MAY, 21, 8, 45);
        
        System.out.println(kursbeginn.format(format2));
    }
}
