package org.repos;

import org.common.DBConnectionManager;
import org.entities.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(City city) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "INSERT INTO cities (name) "
                    + "VALUES ('" + city.getName() + "')";

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int update(City city) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "UPDATE cities SET "
                    + "name = '" + city.getName() + "' "
                    + "WHERE id = " + city.getId();

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int delete(Integer id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "DELETE FROM cities "
                    + "WHERE id = " + id;

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public List<City> selectAll() throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM cities";
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<City> allCities = new ArrayList<>();
            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));

                allCities.add(city);
            }
            return allCities;
        }
    }

    public City select(int id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM cities WHERE id = " + id;
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));

                return city;
            }
            return null;
        }
    }
}
