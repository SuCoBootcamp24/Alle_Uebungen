import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // ArrayList erstellen und Elemente hinzufügen:
        for (int i = 1; i <= 5; i++) list.add(i);


        System.out.println(list.size());
        System.out.println("");


        // Elemente entfernen:
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) list.remove(i);
        } 


        // Größe der ArrayList:
        System.out.println(list.size());
        System.out.println("");


        // Elemente abrufen:
        System.out.println(list.get(1));
        System.out.println("");


        // ArrayList durchlaufen:
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", ");
        System.out.println("");


        //Elemente sortieren:
        for (int i = 10; i <= 20; i++) list.add((int)(Math.random() * 20) + 1);
        
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", ");
        System.out.println("");

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", ");
        System.out.println("");


         //Suche nach einem Element:
        System.out.println(list.contains(4));
        System.out.println("");


        //Teil-ArrayList erstellen:
        List<Integer> list2 = list.subList(0, 3);
        
        for (int i = 0; i < list2.size(); i++) System.out.print(list2.get(i) + ", ");
        System.out.println("");


        //Duplikate entfernen:
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", ");
        System.out.println("");


        //Array → ArrayList Gerade und ungerade zahle separieren
        int[] data = {1, 5, 6, 11, 3, 15, 7, 8, 12, 21, 9, 1038};
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0 && data[i] != 1) {
                evenNumbers.add(data[i]);
            } else {
                oddNumbers.add(data[i]);
            }
        }

        for (int i = 0; i < evenNumbers.size(); i++) System.out.print(evenNumbers.get(i) + ", ");
        System.out.println("");
    
        for (int i = 0; i < oddNumbers.size(); i++) System.out.print(oddNumbers.get(i) + ", ");
        System.out.println("");




    }   
}
