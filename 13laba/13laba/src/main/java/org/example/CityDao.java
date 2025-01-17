package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
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
}
