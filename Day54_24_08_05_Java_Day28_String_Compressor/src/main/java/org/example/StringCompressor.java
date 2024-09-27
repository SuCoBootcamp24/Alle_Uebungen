package org.example;

public class StringCompressor {

    public static String compress(String input) {
        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(currentChar);
                if (count > 1) result.append(count);
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        result.append(currentChar).append(count);
        if (result.length() >= input.length()) return input;
        return result.toString();
    }
}
