package org.example;
public class Greet {
    private String firstname;
    private String lastname;
    private int alter;
    private boolean geschlecht; // true = w, false = m

    public Greet(String name, int alter, boolean geschlecht) {
        this.setName(name);
        this.setAlter(alter);
        this.geschlecht = geschlecht;
    }

    // Hallo Vorname :) (wenn die Person minderjährig ist)
    // Guten Tag Frau/Herr Nachname! (wenn die Person volljährig ist)
    public String greetMe() {
        if(alter < 18) {
            return "Hallo " + this.firstname + " :)";
        } else {
            String anrede = geschlecht ? "Frau" : "Herr";
            return "Guten Tag " + anrede + " " + this.lastname + "!";
        }
    }

    private void setAlter(int alter) {
        if (alter < 0) {
            throw new IllegalArgumentException("Person age must be positive number");
        }
        this.alter = alter;
    }
    private void setName(String name) {
        String[] nameParts = name.split(" ");
        if(nameParts.length != 2) {
            throw new IllegalArgumentException("Person needs firstname and lastname");
        }
        this.firstname = nameParts[0];
        this.lastname = nameParts[1];
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAlter() {
        return alter;
    }

    public boolean isFemale() {
        return geschlecht;
    }

    public String getName() {
        return this.firstname + " " + this.lastname;
    }
}