package org.example;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
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

        CityRepository repository = new CityRepository(cities);

        System.out.println("Жители Москвы, говорящие на русском:");
        List<ResidentType> residents = repository.getResidentsByCityAndLanguage("Москва", "Русский");
        residents.forEach(System.out::println);

        System.out.println("\nГорода, где есть фермеры:");
        List<City> citiesWithFarmers = repository.getCitiesByResidentType("Фермер");
        citiesWithFarmers.forEach(System.out::println);

        System.out.println("\nГород с населением 5000000:");
        Optional<City> cityByPopulation = repository.getCityByPopulation(5000000);
        cityByPopulation.ifPresent(System.out::println);

        System.out.println("\nСамый древний тип жителей:");
        Optional<ResidentType> oldestResidentType = repository.getOldestResidentType();
        oldestResidentType.ifPresent(System.out::println);
    }
}

