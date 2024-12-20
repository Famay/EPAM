package B;


import org.B.RoadSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoadSystemTest {

    private RoadSystem roadSystem;

    @BeforeEach
    public void setUp() {
        roadSystem = new RoadSystem();
        roadSystem.addRoad("Полоцк", "Минск", 200);
        roadSystem.addRoad("Полоцк", "Витебск", 100);
        roadSystem.addRoad("Минск", "Гомель", 300);
        roadSystem.addRoad("Гомель", "Брест", 500);
    }

    @Test
    public void testAddRoad() {
        // Проверяем, что дороги добавляются корректно
        List<RoadSystem.Road> minskRoads = roadSystem.graph.get("Минск");
        assertNotNull(minskRoads);
        assertTrue(minskRoads.stream().anyMatch(road -> road.destination.equals("Полоцк") && road.distance == 200));
        assertTrue(minskRoads.stream().anyMatch(road -> road.destination.equals("Гомель") && road.distance == 300));
    }

    @Test
    public void testFindShortestPath() {
        // Проверяем, что кратчайший путь из Полоцка в Брест работает правильно
        List<String> path = roadSystem.findShortestPath("Полоцк", "Брест");
        assertNotNull(path);
        assertEquals(List.of("Полоцк", "Минск", "Гомель", "Брест"), path);
    }

    @Test
    public void testFindShortestPathNoPath() {

        List<String> path = roadSystem.findShortestPath("Витебск", "Брест");

    }

    @Test
    public void testSaveToFile() throws IOException {
        // Проверяем сохранение объекта в файл
        File file = new File("roadSystem.ser");
        if (file.exists()) {
            file.delete();
        }

        roadSystem.saveToFile("roadSystem.ser");

        // Проверяем, что файл был создан
        assertTrue(file.exists());
    }

    @Test
    public void testLoadFromFile() throws IOException, ClassNotFoundException {
        // Сначала сохраняем систему в файл
        roadSystem.saveToFile("roadSystem.ser");

        // Загружаем систему из файла
        RoadSystem loadedSystem = RoadSystem.loadFromFile("roadSystem.ser");

        // Проверяем, что загруженная система не пуста и имеет такие же данные
        assertNotNull(loadedSystem);
        assertTrue(loadedSystem.graph.containsKey("Полоцк"));
        assertTrue(loadedSystem.graph.containsKey("Минск"));
    }
}

