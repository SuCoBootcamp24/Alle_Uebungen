package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {
    private User user;
    @BeforeEach
    void setUp() {
        this.user = new User("user");
    }

    @Test
    void increaseScore() {
        this.user.increaseScore();

        assertEquals(1, user.getScore());
    }

    @Test
    void getUsername() {
        assertEquals("user", user.getUsername());
    }

    @Test
    void getScore() {
        user.setScore(20);

        assertEquals(20, user.getScore());
    }
}