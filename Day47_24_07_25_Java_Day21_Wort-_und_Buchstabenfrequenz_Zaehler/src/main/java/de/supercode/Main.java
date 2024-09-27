package de.supercode;

public class Main {
    public static void main(String[] args) {

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel ligula at ex rutrum lobort et ultr ac nunc. Donec euismod ex Lorem ipsum dolor sit amet";

        Counter.countCharacter(text);
        Counter.countWord(text);

        System.out.println(Counter.getCharMap());
        System.out.println(Counter.getWordMap());

    }
}