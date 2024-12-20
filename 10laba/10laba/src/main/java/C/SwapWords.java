package C;

import java.io.*;
import java.util.*;

public class SwapWords {

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.txt"; // Входной файл

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = swapFirstAndLastWords(line);
                System.out.println(modifiedLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public static String swapFirstAndLastWords(String line) {
        String[] words = line.split("\\s+"); // Разделение строки на слова

        if (words.length < 2) {
            return line; // Если меньше двух слов, возвращаем строку без изменений
        }

        // Меняем первое и последнее слова местами
        String temp = words[0];
        words[0] = words[words.length - 1];
        words[words.length - 1] = temp;

        // Собираем строку обратно
        return String.join(" ", words);
    }
}
