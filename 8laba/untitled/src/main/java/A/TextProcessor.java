package A;

public class TextProcessor {
    public static String removeNonLetters(String text) {
        return text.replaceAll("[^a-zA-Zа-яА-Я]+", " ").trim();
    }
}
