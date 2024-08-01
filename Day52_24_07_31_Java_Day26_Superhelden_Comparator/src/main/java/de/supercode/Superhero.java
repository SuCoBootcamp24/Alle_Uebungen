package de.supercode;

import java.util.Objects;

public class Superhero {

    private String name;
    private int powerlevel;

    private int speed;

    private Category category;

    public Superhero(String name, int powerlevel, int speed, Category category) {
        this.name = name;
        this.powerlevel = powerlevel;
        this.speed = speed;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerlevel() {
        return powerlevel;
    }

    public void setPowerlevel(int powerlevel) {
        this.powerlevel = powerlevel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero superhero = (Superhero) o;
        return powerlevel == superhero.powerlevel && speed == superhero.speed && Objects.equals(name, superhero.name) && category == superhero.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, powerlevel, speed, category);
    }

    @Override
    public String toString() {
        return STR."Superhero{name='\{name}\{'\''}, powerlevel=\{powerlevel}, speed=\{speed}, category=\{category}\{'}'}";
    }
}
