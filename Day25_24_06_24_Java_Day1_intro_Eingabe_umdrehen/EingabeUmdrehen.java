import java.util.ArrayList;
import java.util.Scanner;


public class EingabeUmdrehen {
    public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordArray = new ArrayList<>();
        String line;

        System.out.println("Geben Sie Ihre einzelnen Wörter ein (nur Enter zum Beenden)");

        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                scanner.close();
                break;
            }
            wordArray.add(line);
        }

        System.out.println("________________________________");
        for (int i = wordArray.size(); i > 0; i--) {
        System.out.println(wordArray.get(i - 1));
        }
    }
}
