package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressorTest {

    @Test
    public void compressInShorterForm() {
        String s1 = "aabccccc";
        String s2 = "aaabbbcccaaa";

        assertEquals("a2bc5", StringCompressor.compress(s1));
        assertEquals("a3b3c3a3", StringCompressor.compress(s2));

    }

}