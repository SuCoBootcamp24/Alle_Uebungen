import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
    
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("E dd.MMM HH:mm");

        LocalDateTime now = DateTime.timeNow();
        System.out.println(now.format(format1));

        System.out.println("");
        now = DateTime.changeDay(now, 5);
        System.out.println(now.format(format1));
        System.out.println("");
        
        now = DateTime.changeDay(now, -4);
        System.out.println(now.format(format1));
        System.out.println("");

        LocalDateTime birthday = LocalDateTime.of(1991, Month.AUGUST, 19, 0, 0);
        System.out.println(DateTime.calcAge(birthday) + " Jahre");

        LocalDateTime time1 = LocalDateTime.of(2023, 7, 11, 10, 0);
        LocalDateTime time2 = LocalDateTime.of(2023, 7, 11, 12, 30);

    
        System.out.println(DateTime.timeDiff(time1, time2));
        
        DateTime.thisDay(now);
    }
}
