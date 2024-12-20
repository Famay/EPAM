import A.TextProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {
    @Test
    void testRemoveNonLetters() {
        String input = "Привет, мир! 123...";
        String expected = "Привет мир";
        assertEquals(expected, TextProcessor.removeNonLetters(input));
    }
}