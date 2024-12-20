import B.WordProcessor;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {
    @Test
    void testSortByVowelRatio() {
        String input = "дом аист солнце";
        List<String> expected = List.of("дом", "солнце", "аист");
        assertEquals(expected, WordProcessor.sortByVowelRatio(input));
    }
}