package A;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ImageTransferTest {

    private static final Path TEST_FILE = Path.of("test_image.jpg");
    private static final Path RECEIVED_FILE = Path.of("received_image.jpg");
    private static final int PORT = 12345;
    private static Thread serverThread;

    @BeforeAll
    static void setUp() throws IOException {
        // Создаём тестовый файл для отправки
        Files.writeString(TEST_FILE, "Тестовое содержимое файла");

        // Запускаем сервер в отдельном потоке
        serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                while (true) {
                    try (Socket clientSocket = serverSocket.accept();
                         OutputStream output = clientSocket.getOutputStream()) {
                        Files.copy(TEST_FILE, output);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка сервера: " + e.getMessage(), e);
            }
        });
        serverThread.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        // Останавливаем сервер и удаляем временные файлы
        serverThread.interrupt();
        Files.deleteIfExists(TEST_FILE);
        Files.deleteIfExists(RECEIVED_FILE);
    }

    @Test
    void testFileTransfer() throws IOException {
        // Подключаемся к серверу и загружаем файл
        try (Socket socket = new Socket("localhost", PORT);
             InputStream input = socket.getInputStream();
             OutputStream output = Files.newOutputStream(RECEIVED_FILE)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        // Проверяем, что файл был получен и его содержимое совпадает
        assertTrue(Files.exists(RECEIVED_FILE), "Файл должен существовать");
        assertTrue(Files.mismatch(TEST_FILE, RECEIVED_FILE) == -1, "Файлы должны быть идентичными");
    }
}
