package org.example;

public class User {

    private String username;
    private int score;

    public User(String username) {
        this.username = username;
        this.score = 0;
    }


    //---
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //---

    public void increaseScore() {
        this.score++;
    }


}
