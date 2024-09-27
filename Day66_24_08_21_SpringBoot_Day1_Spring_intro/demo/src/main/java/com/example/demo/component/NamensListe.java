package com.example.demo.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class NamensListe {

    private ArrayList<String> names;

    public NamensListe() {
        this.names = new ArrayList<>();
    }

    public void addName(String name) {
        names.add(name);
    }

    public ArrayList<String> getNames() {
        return names;
    }

}
