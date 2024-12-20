import C.FileNameMatcher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileNameMatcherTest {
    @Test
    void testMatches() {
        assertTrue(FileNameMatcher.matches("*.txt", "file.txt"));
        assertFalse(FileNameMatcher.matches("?.txt", "file.txt"));
        assertTrue(FileNameMatcher.matches("file.*", "file.txt"));
    }
}