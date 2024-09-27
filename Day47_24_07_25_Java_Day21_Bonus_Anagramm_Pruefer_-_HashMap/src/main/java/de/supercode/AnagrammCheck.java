package de.supercode;

import java.util.HashMap;

public class AnagrammCheck {
    
    private static HashMap<Character, Integer> charList = new HashMap<>();


    public static HashMap<Character, Integer> getCharList() {
        return charList;
    }

    public static boolean checkAnagram(String text1, String text2) {
        text1 = cleanText(text1);
        text2 = cleanText(text2);
        if (text1.length()!=text2.length()) return false;
        resetCharList();
        countChars(text1);
        return CheckCharsInStrings(text2);
    }

    private static String cleanText(String text1) {
        text1 = text1.replace(" ", "").toUpperCase();
        return text1;
    }

    private static void resetCharList() {
        charList.clear();
    }

    private static void countChars(String text) {
        for (Character c : text.toCharArray()) {
            charList.put(c, charList.getOrDefault(c, 1) + 1);
        }
    }

    private static boolean CheckCharsInStrings(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!charList.containsKey(c)) return false;
            if (charList.get(c) == 2) charList.remove(c);
            else charList.put(c, charList.get(c) - 1);
        }

        if (charList.isEmpty()) return true;
        return false;
    }

}
