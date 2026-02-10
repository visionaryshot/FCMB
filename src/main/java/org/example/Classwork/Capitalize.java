package org.example.Classwork;

public class Capitalize {

    public static String capitalizeWords(String text) {
        String[] words = text.split(" ");
        String result = "";

        for (String word : words) {
            result += word.substring(0, 1).toUpperCase()
                    + word.substring(1) + " ";
        }

        return result.trim();
    }
}