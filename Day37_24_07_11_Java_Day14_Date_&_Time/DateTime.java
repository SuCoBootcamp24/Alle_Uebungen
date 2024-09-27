import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTime {
    
    public static LocalDateTime timeNow() {
        return LocalDateTime.now();
    }


    public static LocalDateTime changeDay(LocalDateTime date, long day) {
        return date.plusDays(day);
    }

    public static int calcAge(LocalDateTime birthday) {
        LocalDateTime now = timeNow();

        return Period.between(birthday.toLocalDate(), now.toLocalDate()).getYears();
    }

    public static String timeDiff(LocalDateTime time1, LocalDateTime time2){
        Duration duration = Duration.between(time1, time2);
         
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        return hours + ":" + minutes;
    }

    public static void thisDay(LocalDateTime date) {
          DateTimeFormatter format = DateTimeFormatter.ofPattern("E");
        System.out.println("Der Wochentag lautet: " + date.format(format));
    }
}
