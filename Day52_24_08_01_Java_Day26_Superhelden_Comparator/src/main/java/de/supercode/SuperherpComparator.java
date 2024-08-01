package de.supercode;

import java.util.Comparator;

public class SuperherpComparator {

    public static Comparator<Superhero> powerlevelComperator = new Comparator<Superhero>() {
        @Override
        public int compare(Superhero hero1, Superhero hero2) {
            return Integer.compare(hero1.getPowerlevel(), hero2.getPowerlevel());
        }
    };

    public static Comparator<Superhero> speedComparator = (hero1, hero2) -> Integer.compare(hero1.getSpeed(), hero2.getSpeed());

    public static Comparator<Superhero> nameComparator = (hero1, hero2) -> hero1.getName().compareTo(hero2.getName());
}
