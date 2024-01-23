package org.example;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public static String[] filterWords(String[] words, String letters) {
        List<String> filteredWords = new ArrayList<>();

        // Convert the letters string to a set of characters for efficient lookup
        char[] letterSet = letters.toCharArray();

        for (String word : words) {
            // Check if the word contains any letters from the set
            if (containsAnyLetter(word, letterSet)) {
                filteredWords.add(word);
            }
        }

        // Convert the list to an array
        return filteredWords.toArray(new String[0]);
    }

    private static boolean containsAnyLetter(String word, char[] letterSet) {
        for (char letter : letterSet) {
            if (word.contains(String.valueOf(letter))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage:
        String[] words = {"the", "dog", "got", "a", "bone"};
        String letters = "ae";

        // Print the result
        String[] filteredWords = filterWords(words, letters);
        for (String word : filteredWords) {
            System.out.println(word);
        }
    }
}
