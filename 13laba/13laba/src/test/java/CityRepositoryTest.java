import org.example.City;
import org.example.CityRepository;
import org.example.ResidentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityRepositoryTest {

    private CityRepository repository;

    @BeforeEach
    void setUp() {
        List<City> cities = Arrays.asList(
                new City("Москва", 1147, 2511.0, Arrays.asList(
                        new ResidentType("Рабочий", "Русский", 5000000),
                        new ResidentType("Фермер", "Русский", 200000)
                )),
                new City("Париж", 508, 105.4, Arrays.asList(
                        new ResidentType("Художник", "Французский", 300000),
                        new ResidentType("Фермер", "Французский", 100000)
                ))
        );
        repository = new CityRepository(cities);
    }

    @Test
    void testGetResidentsByCityAndLanguage() {
        List<ResidentType> residents = repository.getResidentsByCityAndLanguage("Москва", "Русский");
        assertEquals(2, residents.size(), "Ожидается 2 жителя, говорящих на русском в Москве");
        assertTrue(residents.stream().anyMatch(r -> r.getName().equals("Рабочий")), "Должен быть 'Рабочий'");
        assertTrue(residents.stream().anyMatch(r -> r.getName().equals("Фермер")), "Должен быть 'Фермер'");
    }

    @Test
    void testGetCitiesByResidentType() {
        List<City> cities = repository.getCitiesByResidentType("Фермер");
        assertEquals(2, cities.size(), "Ожидается 2 города, где есть фермеры");
        assertTrue(cities.stream().anyMatch(c -> c.getName().equals("Москва")), "Город должен содержать 'Москва'");
        assertTrue(cities.stream().anyMatch(c -> c.getName().equals("Париж")), "Город должен содержать 'Париж'");
    }

    @Test
    void testGetCityByPopulation() {
        Optional<City> city = repository.getCityByPopulation(5200000);
        assertTrue(city.isPresent(), "Ожидается, что найдется город с населением 5200000");
        assertEquals("Москва", city.get().getName(), "Город с населением 5200000 должен быть 'Москва'");
    }

    @Test
    void testGetCityByPopulation_NotFound() {
        Optional<City> city = repository.getCityByPopulation(10000000);
        assertFalse(city.isPresent(), "Ожидается, что город с населением 10000000 не будет найден");
    }

    @Test
    void testGetOldestResidentType() {
        Optional<ResidentType> residentType = repository.getOldestResidentType();
        assertTrue(residentType.isPresent(), "Ожидается, что будет найден самый древний тип жителей");
        assertEquals("Фермер", residentType.get().getName(), "Самый древний тип жителей должен быть 'Фермер'");
    }
}

