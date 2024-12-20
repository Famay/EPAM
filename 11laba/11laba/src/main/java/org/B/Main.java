package org.B;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RoadSystem roadSystem = new RoadSystem();

        // Добавляем дороги
        roadSystem.addRoad("Полоцк", "Минск", 200);
        roadSystem.addRoad("Полоцк", "Витебск", 100);
        roadSystem.addRoad("Полоцк", "Гродно", 300);
        roadSystem.addRoad("Минск", "Брест", 400);
        roadSystem.addRoad("Витебск", "Гомель", 300);
        roadSystem.addRoad("Гомель", "Брест", 500);

        System.out.println(roadSystem);

        // Поиск кратчайшего пути
        List<String> path = roadSystem.findShortestPath("Полоцк", "Брест");
        System.out.println("Кратчайший путь из Полоцка в Брест: " + path);

        // Сохранение в файл
        try {
            roadSystem.saveToFile("roadSystem.ser");
            System.out.println("Сохранено в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }

        // Загрузка из файла
        try {
            RoadSystem loadedSystem = RoadSystem.loadFromFile("roadSystem.ser");
            System.out.println("Загружено из файла:");
            System.out.println(loadedSystem);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка загрузки: " + e.getMessage());
        }
    }
}
