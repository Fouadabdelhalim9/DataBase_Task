package org.repos;

import org.common.DBConnectionManager;
import org.entities.Brand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Brand brand) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "INSERT INTO brands (name, logo_path) "
                    + "VALUES ('" + brand.getName() + "', '" + brand.getLogoPath() + "')";

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int update(Brand brand) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "UPDATE brands SET "
                    + "name = '" + brand.getName() + "', "
                    + "logo_path = '" + brand.getLogoPath() + "' "
                    + "WHERE id = " + brand.getId();

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int delete(Integer id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "DELETE FROM brands "
                    + "WHERE id = " + id;

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public List<Brand> selectAll() throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM brands";
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Brand> allBrands = new ArrayList<>();
            while (result.next()) {
                Brand brand = new Brand();
                brand.setId(result.getInt("id"));
                brand.setName(result.getString("name"));
                brand.setLogoPath(result.getString("logo_path"));

                allBrands.add(brand);
            }
            return allBrands;
        }
    }

    public Brand select(int id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM brands WHERE id = " + id;
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                Brand brand = new Brand();
                brand.setId(result.getInt("id"));
                brand.setName(result.getString("name"));
                brand.setLogoPath(result.getString("logo_path"));

                return brand;
            }
            return null;
        }
    }
}
