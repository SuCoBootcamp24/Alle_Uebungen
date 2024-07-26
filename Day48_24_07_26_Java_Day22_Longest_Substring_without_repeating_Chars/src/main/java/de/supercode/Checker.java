package de.supercode;

import java.util.HashMap;

public class Checker {

    public static String longestUniqueSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int longestStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (charMap.containsKey(currentChar)) {
                start = Math.max(start, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, i);

            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
                longestStart = start;
            }
        }

        return s.substring(longestStart, longestStart + maxLength);
    }
}
