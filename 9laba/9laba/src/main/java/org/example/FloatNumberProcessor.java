package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FloatNumberProcessor {

    public static void main(String[] args) {
        String filePath = "src/main/resources/numbers.txt"; // Путь к файлу

        try {
            // Собираем числа в список
            List<Double> numbers = processLargeFile(filePath).collect(Collectors.toList());

            // Выполняем вычисления
            double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
            double average = numbers.isEmpty() ? 0 : sum / numbers.size();

            System.out.println("Сумма чисел: " + sum);
            System.out.println("Среднее значение: " + average);
        } catch (CustomException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("Недостаточно памяти для обработки файла.");
            e.printStackTrace();
        }
    }

    public static Stream<Double> processLargeFile(String filePath) throws IOException, CustomException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new CustomException("Файл не найден: " + filePath);
        }

        return Files.lines(Paths.get(filePath))
                .map(line -> {
                    try {
                        String numberString = extractNumber(line);
                        return Double.parseDouble(numberString.replace(",", "."));
                    } catch (NumberFormatException | CustomException e) {
                        System.out.println("Ошибка обработки строки: " + line);
                        return null;
                    }
                })
                .filter(Objects::nonNull); // Удаляем некорректные значения
    }

    private static String extractNumber(String line) throws CustomException {
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            throw new CustomException("Некорректная строка: " + line);
        }
        return parts[0];
    }
}
