
import java.util.Arrays;

public class LiveSession {
    public static void main(String[] args) {
        // LiveSession Challenge 1. create a logic for the method split()

        String input = "Hallo Freunde!";
        String[] test = split(input, "a");
        System.out.println(Arrays.toString(test));
    }

    public static String[] split(String input, String delimiter) {
        int partcounter = 1;
        int index = 0;
        while ((index = input.indexOf(delimiter, index)) != -1) {
            partcounter++;
            index += delimiter.length();
        }
        String[] resultArray = new String[partcounter];
        int partIndex = 0;
        int start = 0;
        int end;

        while ((end = input.indexOf(delimiter, start)) != -1) {
            resultArray[partIndex] = input.substring(start, end);
            partIndex++;
            start = end + delimiter.length();
        }

        resultArray[partIndex] = input.substring(start);

        return resultArray;
    }
}