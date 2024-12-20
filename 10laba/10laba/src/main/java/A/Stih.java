package A;

import java.util.*;
import java.util.stream.Collectors;

public class Stih {

    public static Map<String, Long> countWordFrequency(String text) {
        return Arrays.stream(text.toLowerCase().replaceAll("[^a-zа-яё\\s]", "").split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static Map<Character, Long> countLetterFrequency(String text) {
        return text.toLowerCase().replaceAll("[^a-zа-яё]", "").chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public static void main(String[] args) {

        String text = """
                Через нивы, через горы
                                             И овраги, и болота,
                                             Посреди собачьей своры
                                             И под звук рогов охоты,
                                             На коне, что птицей мчится,
                                             Весь — огонь и удальство,
                                             И с ружьём — лишь гром сравнится
                                             С каждым выстрелом его —
                                             По следам горячим зверя
                                             И в свою удачу веря:
                                             Гоп, гоп, гоп! Вперёд, вперёд!
            """;

        Map<String, Long> wordFrequency = countWordFrequency(text);
        Map<Character, Long> letterFrequency = countLetterFrequency(text);

        System.out.println("\nЧастота повторяемости слов:");
        wordFrequency.forEach((word, freq) -> System.out.println(word + ": " + freq));

        System.out.println("\nЧастота повторяемости букв:");
        letterFrequency.forEach((letter, freq) -> System.out.println(letter + ": " + freq));
    }
}
