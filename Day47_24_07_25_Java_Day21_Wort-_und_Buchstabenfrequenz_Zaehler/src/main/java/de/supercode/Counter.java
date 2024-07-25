package de.supercode;

import java.util.HashMap;

public class Counter {

    private static HashMap<Character,Integer> charMap = new HashMap<>();

    private static HashMap<String, Integer> wordMap = new HashMap<>();


    public static HashMap<Character, Integer> getCharMap() {
        return charMap;
    }

    public static void setCharMap(HashMap<Character, Integer> charMap) {
        Counter.charMap = charMap;
    }

    public static HashMap<String, Integer> getWordMap() {
        return wordMap;
    }

    public static void setWordMap(HashMap<String, Integer> wordMap) {
        Counter.wordMap = wordMap;
    }

    //----

    public static void countCharacter(String text) {
        text = text.replaceAll("[^a-zA-Z]", "");
        for (char c : text.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
    }

    public static void countWord(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
    }

}
