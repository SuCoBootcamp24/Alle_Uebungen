package de.supercode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Erstellen eines neuen HashSets
        Set<Integer> set = new HashSet<>();

        // Elemente zum Set hinzufügen
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(5); // Duplikate werden nicht hinzugefügt

        // Überprüfen, ob das Set leer ist
        System.out.println("Ist das Set leer? " + set.isEmpty());

        // Anzeigen der Elemente des Sets
        System.out.println("Elemente im Set: " + set);

        // Überprüfen, ob ein bestimmtes Element im Set enthalten ist
        System.out.println("Enthält das Set die Zahl 10? " + set.contains(10));

        // Entfernen eines Elements aus dem Set
        set.remove(10);
        System.out.println("Enthält das Set die Zahl 10 nach dem Entfernen? " + set.contains(10));

        // Anzeigen der Größe des Sets
        System.out.println("Größe des Sets: " + set.size());

        // Iterieren über die Elemente des Sets
        System.out.println("Iterieren über die Elemente des Sets:");
        for (Integer num : set) {
            System.out.println(num);
        }

        // Löschen des Sets
        set.clear();
        System.out.println("Ist das Set leer nach dem Löschen? " + set.isEmpty());


        // Arbeiten mit einem zweiten Set und der retainAll-Methode
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Behalte nur die gemeinsamen Elemente in set1
        set1.retainAll(set2);


        System.out.println();
        System.out.println("------------------------");
        System.out.println();

        // Erstellen einer TreeMap mit natürlicher Ordnung
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Alice", "Info1");
        treeMap.put("Bob", "Info2");
        treeMap.put("Charlie", "Info3");

        // Überprüfen, ob die TreeMap leer ist
        System.out.println("Ist die TreeMap leer? " + treeMap.isEmpty());

        // Anzeigen der Elemente der TreeMap
        System.out.println("Elemente der TreeMap: " + treeMap);

        // Überprüfen, ob ein bestimmter Schlüssel in der TreeMap enthalten ist
        System.out.println("Enthält die TreeMap den Schlüssel 'Bob'? " + treeMap.containsKey("Bob"));

        // Entfernen eines Schlüssel-Wert-Paares aus der TreeMap
        treeMap.remove("Bob");
        System.out.println("Elemente der TreeMap nach dem Entfernen von 'Bob': " + treeMap);

        // Anzeigen der Größe der TreeMap
        System.out.println("Größe der TreeMap: " + treeMap.size());

        // Iterieren über die Einträge der TreeMap
        System.out.println("Iterieren über die Einträge der TreeMap:");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Löschen der TreeMap
        treeMap.clear();
        System.out.println("Ist die TreeMap leer nach dem Löschen? " + treeMap.isEmpty());

        // Erstellen einer zweiten TreeMap mit weiteren Schlüssel-Wert-Paaren
        TreeMap<String, String> treeMap2 = new TreeMap<>();
        treeMap2.put("David", "Info4");
        treeMap2.put("Eve", "Info5");
        treeMap2.put("Charlie", "Info6");

        // Anzeigen der Elemente der zweiten TreeMap
        System.out.println("Elemente der zweiten TreeMap: " + treeMap2);

        // Behalten nur die gemeinsamen Schlüssel zwischen den beiden TreeMaps
        treeMap.put("Alice", "Info1");
        treeMap.put("Charlie", "Info3");

        System.out.println("Elemente der ersten TreeMap vor retainAll: " + treeMap);

        // Erstellen einer Kopie der ersten TreeMap, um die gemeinsamen Schlüssel zu behalten
        TreeMap<String, String> commonKeysTreeMap = new TreeMap<>(treeMap);
        commonKeysTreeMap.keySet().retainAll(treeMap2.keySet());

        // Anzeigen der gemeinsamen Schlüssel und deren Werte
        System.out.println("Gemeinsame Schlüssel in beiden TreeMaps: " + commonKeysTreeMap);


        System.out.println();
        System.out.println("------------------------");
        System.out.println();

        // Erstellen einer TreeMap mit natürlicher Ordnung
        TreeMap<Integer, String> treeMap3 = new TreeMap<>();
        treeMap3.put(15, "Fünfzehn");
        treeMap3.put(10, "Zehn");
        treeMap3.put(20, "Zwanzig");
        treeMap3.put(5, "Fünf");

        // Anzeigen der Elemente der TreeMap in natürlicher Ordnung
        System.out.println("TreeMap in natürlicher Ordnung: " + treeMap3);



        System.out.println();
        System.out.println("------------------------");
        System.out.println();

        // Erstellen einer TreeMap mit benutzerdefiniertem Comparator (umgekehrte Reihenfolge der Schlüssel)
        TreeMap<Integer, String> treeMap4 = new TreeMap<>(Comparator.reverseOrder());
        treeMap4.put(15, "Fünfzehn");
        treeMap4.put(10, "Zehn");
        treeMap4.put(20, "Zwanzig");
        treeMap4.put(5, "Fünf");

        // Anzeigen der Elemente der TreeMap in benutzerdefinierter Reihenfolge
        System.out.println("TreeMap in benutzerdefinierter Reihenfolge: " + treeMap4);




        System.out.println();
        System.out.println("------------------------");
        System.out.println();

// Erstellen einer TreeMap mit natürlicher Ordnung der Person-Objekte (nach Alter)
        TreeMap<Person, String> treeMap5 = new TreeMap<>();
        treeMap5.put(new Person("Alice", 30), "Alice's Info");
        treeMap5.put(new Person("Bob", 25), "Bob's Info");
        treeMap5.put(new Person("Charlie", 35), "Charlie's Info");

        // Anzeigen der Elemente der TreeMap in natürlicher Ordnung
        System.out.println("TreeMap nach Alter sortiert: " + treeMap5);

        // Erstellen einer TreeMap mit benutzerdefiniertem Comparator (nach Name)
        TreeMap<Person, String> treeMapByName = new TreeMap<>(Comparator.comparing(p -> p.name));
        // TreeMap<Person, String> peopleByAgeDesc = new TreeMap<>(Comparator.comparingInt(Person::getAge).reversed());

        treeMapByName.put(new Person("Alice", 30), "Alice's Info");
        treeMapByName.put(new Person("Bob", 25), "Bob's Info");
        treeMapByName.put(new Person("Charlie", 35), "Charlie's Info");

        // Anzeigen der Elemente der TreeMap nach Namen sortiert
        System.out.println("TreeMap nach Namen sortiert: " + treeMapByName);
    }
}