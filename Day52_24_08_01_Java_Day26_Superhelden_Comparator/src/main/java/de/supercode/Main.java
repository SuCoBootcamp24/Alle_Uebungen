package de.supercode;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Superhero> superheroes = new ArrayList<>();
        addHeros(superheroes);
        System.out.println();
        printList(superheroes);
        superheroes.sort(SuperherpComparator.nameComparator);
        printList(superheroes);
        superheroes.sort(SuperherpComparator.powerlevelComperator.reversed().thenComparing(SuperherpComparator.speedComparator.reversed()));
        printList(superheroes);

    }





    private static void addHeros(ArrayList<Superhero> superheroes) {


        superheroes.add(new Superhero("Superman", 100, 90, Category.HERO));
        superheroes.add(new Superhero("Batman", 85, 75, Category.HERO));
        superheroes.add(new Superhero("Wonder Woman", 95, 85, Category.HERO));
        superheroes.add(new Superhero("Flash", 80, 100, Category.HERO));
        superheroes.add(new Superhero("Iron Man", 90, 80, Category.HERO));
        superheroes.add(new Superhero("Captain America", 85, 70, Category.HERO));
        superheroes.add(new Superhero("Son Goku", 9001, 1000, Category.HERO));

        superheroes.add(new Superhero("Joker", 70, 60, Category.VILLAIN));
        superheroes.add(new Superhero("Lex Luthor", 75, 65, Category.VILLAIN));
        superheroes.add(new Superhero("Thanos", 95, 50, Category.VILLAIN));
        superheroes.add(new Superhero("Green Goblin", 80, 70, Category.VILLAIN));
        superheroes.add(new Superhero("Magneto", 85, 60, Category.VILLAIN));

    }

    private static void printList(ArrayList<Superhero> superheroes) {
        superheroes.forEach(System.out::println);

        System.out.println();
        System.out.println();
    }
}