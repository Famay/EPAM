import org.example.CityQueries;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityDaoTest {
    private final CityQueries cityQueries = new CityQueries();

    @Test
    void testGetResidentsByCityAndLanguage() throws Exception {
        // Жители Москвы, говорящие на русском
        List<String> residents = cityQueries.getResidentsByCityAndLanguage("Москва", "Русский");
        assertNotNull(residents, "Результат не должен быть null");
        assertTrue(residents.size() > 0, "Список жителей не должен быть пустым");
        assertTrue(residents.contains("Рабочие"), "Список должен содержать 'Рабочие'");
    }

    @Test
    void testGetCitiesByResidentType() throws Exception {
        // Города, где живут рабочие
        List<String> cities = cityQueries.getCitiesByResidentType("Рабочие");
        assertNotNull(cities, "Результат не должен быть null");
        assertTrue(cities.size() > 0, "Список городов не должен быть пустым");
        assertTrue(cities.contains("Москва"), "Список должен содержать 'Москва'");
    }
}
