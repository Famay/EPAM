package org.example.A;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageTransferServer {

    public static void main(String[] args) {
        int port = 12345;
        Path filePath = Path.of("C:\\Users\\SystemX\\IdeaProjects\\EPAM\\14laba\\14laba\\src\\main\\java\\org\\example\\A\\image_to_send.png"); // Заранее подготовленный файл для отправки

        if (!Files.exists(filePath)) {
            System.err.println("Файл для отправки не найден: " + filePath.toAbsolutePath());
            return;
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание подключения клиентов...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     OutputStream output = clientSocket.getOutputStream()) {

                    System.out.println("Клиент подключён: " + clientSocket.getInetAddress());

                    // Отправка файла
                    Files.copy(filePath, output);
                    System.out.println("Файл отправлен клиенту: " + clientSocket.getInetAddress());
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }
}
