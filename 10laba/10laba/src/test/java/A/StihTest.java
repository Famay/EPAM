package A;


import A.Stih;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StihTest {

    @Test
    void testCountWordFrequency() {
        String text = "Привет мир! Привет всем.";
        Map<String, Long> result = Stih.countWordFrequency(text);

        assertEquals(3, result.size());
        assertEquals(2, result.get("привет"));
        assertEquals(1, result.get("мир"));
        assertEquals(1, result.get("всем"));
    }

    @Test
    void testEmptyString() {
        String text = "";
        Map<String, Long> wordResult = Stih.countWordFrequency(text);
        Map<Character, Long> letterResult = Stih.countLetterFrequency(text);

        assertEquals(0, wordResult.size());
        assertEquals(0, letterResult.size());
    }

    @Test
    void testSpecialCharacters() {
        String text = "!!! @@@ ###";
        Map<String, Long> wordResult = Stih.countWordFrequency(text);
        Map<Character, Long> letterResult = Stih.countLetterFrequency(text);

        assertEquals(0, wordResult.size());
        assertEquals(0, letterResult.size());
    }
}