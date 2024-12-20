package C;

import C.SwapWords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapWordsTest {

    @Test
    void testSwapFirstAndLastWords_NormalCase() {
        String input = "Привет мир как дела";
        String expected = "дела мир как Привет";
        assertEquals(expected, SwapWords.swapFirstAndLastWords(input));
    }

    @Test
    void testSwapFirstAndLastWords_SingleWord() {
        String input = "Привет";
        String expected = "Привет"; // Одно слово не меняется
        assertEquals(expected, SwapWords.swapFirstAndLastWords(input));
    }

    @Test
    void testSwapFirstAndLastWords_EmptyLine() {
        String input = "";
        String expected = ""; // Пустая строка остается пустой
        assertEquals(expected, SwapWords.swapFirstAndLastWords(input));
    }

    @Test
    void testSwapFirstAndLastWords_TwoWords() {
        String input = "Привет мир";
        String expected = "мир Привет"; // Два слова меняются местами
        assertEquals(expected, SwapWords.swapFirstAndLastWords(input));
    }

    @Test
    void testSwapFirstAndLastWords_WithExtraSpaces() {
        String input = "  Привет   мир   ";
        String expected = "мир Привет"; // Лишние пробелы игнорируются
        assertEquals(expected, SwapWords.swapFirstAndLastWords(input.trim()));
    }
}
