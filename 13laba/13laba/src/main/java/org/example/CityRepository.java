package org.example;



import java.util.*;
import java.util.stream.Collectors;

public class CityRepository {

    private final List<City> cities;

    public CityRepository(List<City> cities) {
        this.cities = cities;
    }

    public List<ResidentType> getResidentsByCityAndLanguage(String cityName, String language) {
        return cities.stream()
                .filter(city -> city.getName().equalsIgnoreCase(cityName))
                .flatMap(city -> city.getResidentTypes().stream())
                .filter(resident -> resident.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
    }

    public List<City> getCitiesByResidentType(String residentTypeName) {
        return cities.stream()
                .filter(city -> city.getResidentTypes().stream()
                        .anyMatch(resident -> resident.getName().equalsIgnoreCase(residentTypeName)))
                .collect(Collectors.toList());
    }

    public Optional<City> getCityByPopulation(int population) {
        return cities.stream()
                .filter(city -> city.getResidentTypes().stream()
                        .mapToInt(ResidentType::getPopulation)
                        .sum() == population)
                .findFirst();
    }

    public Optional<ResidentType> getOldestResidentType() {
        return cities.stream()
                .flatMap(city -> city.getResidentTypes().stream())
                .min(Comparator.comparingInt(resident -> resident.getPopulation()));
    }
}

