package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void findMax() {
        MathUtils mathUtils = new MathUtils();

        assertEquals(10, mathUtils.max(5, 10));
        assertEquals(5, mathUtils.max(5, 5));
        assertEquals(5, mathUtils.max(5, 0));
    }

    @Test
    void findMin() {
        MathUtils mathUtils = new MathUtils();

        assertEquals(1, mathUtils.min(1,200));
        assertEquals(20, mathUtils.min(20,20));
        assertEquals(5, mathUtils.min(200,5));
    }
}