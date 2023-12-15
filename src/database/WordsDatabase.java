package database;

import java.util.Random;

public class WordsDatabase {
    private static final String[] words = {"transplant", "dwarves", "stronghold", "pneumonia", "rhythm", "transcript"};

    public static String drawRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }
}
