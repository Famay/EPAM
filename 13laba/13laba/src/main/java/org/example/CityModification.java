package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityModification {
    public void addCity(String name, int yearFounded, double area, int population) throws SQLException {
        String query = "INSERT INTO cities (name, year_founded, area, population) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, yearFounded);
            statement.setDouble(3, area);
            statement.setInt(4, population);

            statement.executeUpdate();
        }
    }

    public void addResidentType(int cityId, String name, String language) throws SQLException {
        String query = "INSERT INTO resident_types (city_id, name, language) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cityId);
            statement.setString(2, name);
            statement.setString(3, language);

            statement.executeUpdate();
        }
    }
}
