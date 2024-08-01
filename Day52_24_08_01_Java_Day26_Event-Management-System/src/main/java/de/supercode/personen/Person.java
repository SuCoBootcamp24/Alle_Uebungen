package de.supercode.personen;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String name;

    private LocalDate geburtstag;

    private Rolle rolle;

    public Person(String name, LocalDate geburtstag) {
        this.name = name;
        this.geburtstag = geburtstag;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        this.geburtstag = geburtstag;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(geburtstag, person.geburtstag) && rolle == person.rolle;
    }


    @Override
    public String toString() {
        return STR."Person{name='\{name}\{'\''}, geburtstag=\{geburtstag}, rolle=\{rolle}\{'}'}";
    }
}
