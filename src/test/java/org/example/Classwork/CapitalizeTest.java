package org.example.Classwork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTest {

    @Test
    void capitalizeWords() {
        String text = "hello world";
        String expected = "Hello World";

        String actual = Capitalize.capitalizeWords(text);

        assertEquals(expected, actual);

    }


}