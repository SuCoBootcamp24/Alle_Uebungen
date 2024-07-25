package de.supercode;

public class Main {
    public static void main(String[] args) {
        String Text1 = "Tom Marvolo Riddle";
        String Text2 = "i am Lord Voldemort";

        System.out.println(AnagrammCheck.checkAnagram(Text1, Text2)); // true
        System.out.println(AnagrammCheck.getCharList());
        System.out.println("--------------------------------");

        String Text3 = "Kaffe";
        String Text4 = "noTee";

        System.out.println(AnagrammCheck.checkAnagram(Text3, Text4)); // false
        System.out.println(AnagrammCheck.getCharList());
    }
}