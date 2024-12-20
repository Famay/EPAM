import org.example.CustomException;
import org.example.FloatNumberProcessor;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

class FloatNumberProcessorTest {

    @Test
     void testValidFileProcessing() throws IOException, CustomException {
        String content = "123.45 en\n67,89 ru\n-98765.4321 en";
        Path tempFile = Files.createTempFile("test_numbers", ".txt");
        Files.writeString(tempFile, content);

        List<Double> numbers = FloatNumberProcessor.processLargeFile(tempFile.toString()).collect(Collectors.toList());

        assertEquals(3, numbers.size());
        assertEquals(123.45, numbers.get(0));
        assertEquals(67.89, numbers.get(1));
        assertEquals(-98765.4321, numbers.get(2));

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testInvalidNumber() throws IOException, CustomException {
        String content = "invalid_number ru\n123.45 en";
        Path tempFile = Files.createTempFile("test_invalid_numbers", ".txt");
        Files.writeString(tempFile, content);

        List<Double> numbers = FloatNumberProcessor.processLargeFile(tempFile.toString()).collect(Collectors.toList());

        assertEquals(1, numbers.size());
        assertEquals(123.45, numbers.get(0));

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testMissingFile() {
        assertThrows(CustomException.class, () -> {
            FloatNumberProcessor.processLargeFile("non_existing_file.txt");
        });
    }

    @Test
    void testInvalidLocale() throws IOException, CustomException {
        String content = "123.45 xx";
        Path tempFile = Files.createTempFile("test_invalid_locale", ".txt");
        Files.writeString(tempFile, content);

        List<Double> numbers = FloatNumberProcessor.processLargeFile(tempFile.toString()).collect(Collectors.toList());

        assertFalse(numbers.isEmpty());
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testLargeFileProcessing() throws IOException, CustomException {
        Path tempFile = Files.createTempFile("test_large_file", ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            for (int i = 0; i < 1_000_000; i++) {
                writer.write(i + ".0 en\n");
            }
        }

        assertDoesNotThrow(() -> {
            Stream<Double> numbersStream = FloatNumberProcessor.processLargeFile(tempFile.toString());
            assertEquals(1_000_000, numbersStream.count());
        });

        Files.deleteIfExists(tempFile);
    }
}
