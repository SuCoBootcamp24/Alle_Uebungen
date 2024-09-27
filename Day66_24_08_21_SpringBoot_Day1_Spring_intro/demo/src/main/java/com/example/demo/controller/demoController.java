package com.example.demo.controller;

import com.example.demo.component.NamensListe;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class demoController {


    NamensListe namensListe;

    public demoController(NamensListe namensListe) {
        this.namensListe = namensListe;
    }


    @GetMapping("/namensliste")
    public ArrayList<String> getNamensListe() {
        return namensListe.getNames();
    }

    @PostMapping("/namensliste")
    public void addName(@RequestParam String name) {
        namensListe.addName(name);
    }




    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/bye")
    public String goodbyeWorld() {
        return "Goodbye, World!";
    }

}
