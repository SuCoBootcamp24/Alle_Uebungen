import java.util.Scanner;

public class PwGenerator {
    // 1. Create a password generator method. every first letter (words) schould take out
    // 2. Create a password generator method. every last letter (words) schould take out in camelcase
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String userText = userInput(scanner);
            System.out.println(generatePwFirstChar(userText));
            System.out.println(generatePwLastChar(userText));
        }
    }

    private static String userInput(Scanner scanner) {
        System.out.println("Geben Sie ihr Satz ein um das Passwort zu generieren:");
        return scanner.nextLine();
    }

    private static String[] splitString (String input){
        return input.split(" ");
    }

    private static String generatePwFirstChar(String input) {
        String result = "";
        String[] wordlist = splitString(input);

        for (int index = 0; index < wordlist.length; index++) {
            result += wordlist[index].charAt(0);
        }

        return result;
    }

    private static String generatePwLastChar(String input) {
        int counter = 0 ;
        String result = "";
        String[] wordlist = splitString(input);

        for (int index = 0; index < wordlist.length; index++) {
            if (counter % 2 == 0) {
                result += wordlist[index].toUpperCase().charAt(wordlist[index].length() -1);
                counter++;
            } else {
                result += wordlist[index].toLowerCase().charAt(wordlist[index].length() -1);
                counter++;
            }
        }

        return result;
    }
}
