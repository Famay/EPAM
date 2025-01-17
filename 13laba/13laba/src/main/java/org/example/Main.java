package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        CityQueries queries = new CityQueries();
        CityModification modification = new CityModification();

        try {
            System.out.println("Жители Москвы, говорящие на русском:");
            System.out.println(queries.getResidentsByCityAndLanguage("Москва", "Русский"));

            System.out.println("\nГорода, где живут рабочие:");
            System.out.println(queries.getCitiesByResidentType("Рабочие"));

            System.out.println("\nГород с населением 12506468:");
            System.out.println(queries.getCityAndResidentsByPopulation(12506468));

            System.out.println("\nСамый древний тип жителей:");
            System.out.println(queries.getOldestResidentType());

            System.out.println("\nДобавляем новый город и тип жителей...");
            modification.addCity("Казань", 1005, 425.3, 1200000);
            modification.addResidentType(3, "Студенты", "Татарский");

        } catch (SQLException e) {
            System.out.println("Произошла ошибка при выполнении запросов:");
            e.printStackTrace();
        }
    }
}
