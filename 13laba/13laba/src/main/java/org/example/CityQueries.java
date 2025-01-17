package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityQueries {
    public List<String> getResidentsByCityAndLanguage(String cityName, String language) throws SQLException {
        String query = """
            SELECT rt.name 
            FROM resident_types rt
            JOIN cities c ON rt.city_id = c.id
            WHERE c.name = ? AND rt.language = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cityName);
            statement.setString(2, language);

            ResultSet resultSet = statement.executeQuery();
            List<String> residents = new ArrayList<>();
            while (resultSet.next()) {
                residents.add(resultSet.getString("name"));
            }
            return residents;
        }
    }

    public List<String> getCitiesByResidentType(String residentType) throws SQLException {
        String query = """
            SELECT c.name 
            FROM cities c
            JOIN resident_types rt ON c.id = rt.city_id
            WHERE rt.name = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, residentType);

            ResultSet resultSet = statement.executeQuery();
            List<String> cities = new ArrayList<>();
            while (resultSet.next()) {
                cities.add(resultSet.getString("name"));
            }
            return cities;
        }
    }

    public String getCityAndResidentsByPopulation(int population) throws SQLException {
        String query = """
            SELECT c.name, rt.name, rt.language 
            FROM cities c
            JOIN resident_types rt ON c.id = rt.city_id
            WHERE c.population = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, population);

            ResultSet resultSet = statement.executeQuery();
            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                if (result.length() == 0) {
                    result.append("City: ").append(resultSet.getString("name")).append("\n");
                }
                result.append("Resident Type: ").append(resultSet.getString("name"))
                        .append(", Language: ").append(resultSet.getString("language"))
                        .append("\n");
            }
            return result.toString();
        }
    }

    public String getOldestResidentType() throws SQLException {
        String query = """
            SELECT rt.name, MIN(c.year_founded) as year 
            FROM resident_types rt
            JOIN cities c ON rt.city_id = c.id
            GROUP BY rt.name
            ORDER BY year ASC
            LIMIT 1
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "Oldest Resident Type: " + resultSet.getString("name") +
                        ", Year Founded: " + resultSet.getInt("year");
            }
            return "No data found.";
        }
    }
}
