package org.example.A;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageReceiverClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;
        Path savePath = Path.of("received_image.jpg"); // Сохранение в текущей директории

        try (Socket socket = new Socket(serverAddress, port);
             InputStream input = socket.getInputStream()) {

            System.out.println("Соединение с сервером установлено.");

            // Принять файл
            try (OutputStream fileOutput = Files.newOutputStream(savePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                System.out.println("Начало загрузки файла...");

                while ((bytesRead = input.read(buffer)) != -1) {
                    fileOutput.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Файл успешно сохранён по пути: " + savePath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка при получении файла: " + e.getMessage());
        }
    }
}
