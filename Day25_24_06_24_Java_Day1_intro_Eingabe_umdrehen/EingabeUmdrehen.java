import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EingabeUmdrehen {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> wordArray = new ArrayList<String>();


        System.out.println("Wörter mit enter eingeben:");
        
        String line;

       for (int i = 0; i < 3; i++) {
        line = reader.readLine();
        wordArray.add(line);
       }

        for (int i = wordArray.size(); i > 0; i--) {
        System.out.println(wordArray.get(i - 1));
        }
    }
}
