package B;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordProcessor {
    public static List<String> sortByVowelRatio(String text) {
        List<String> words = new ArrayList<>(List.of(text.split("\\s+")));
        words.sort(Comparator.comparingDouble(WordProcessor::vowelRatio));
        return words;
    }

    private static double vowelRatio(String word) {
        long vowels = word.chars()
                .filter(c -> "aeiouаеёиоуыэюя".indexOf(Character.toLowerCase(c)) != -1)
                .count();
        return (double) vowels / word.length();
    }
}