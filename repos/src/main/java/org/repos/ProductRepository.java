package org.repos;

import org.common.DBConnectionManager;
import org.entities.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Product product) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "INSERT INTO products (name, description, picture_path, category_id, brand_id) "
                    + "VALUES ('" + product.getName() + "', '" + product.getDescription() + "', '"
                    + product.getPicturePath() + "', " + product.getCategoryId() + ", " + product.getBrandId() + ")";

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int update(Product product) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "UPDATE products SET "
                    + "name = '" + product.getName() + "', "
                    + "description = '" + product.getDescription() + "', "
                    + "picture_path = '" + product.getPicturePath() + "', "
                    + "category_id = " + product.getCategoryId() + ", "
                    + "brand_id = " + product.getBrandId() + " "
                    + "WHERE id = " + product.getId();

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int delete(Integer id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "DELETE FROM products "
                    + "WHERE id = " + id;

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public List<Product> selectAll() throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM products";
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Product> allProducts = new ArrayList<>();
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPicturePath(result.getString("picture_path"));
                product.setCategoryId(result.getInt("category_id"));
                product.setBrandId(result.getInt("brand_id"));

                allProducts.add(product);
            }
            return allProducts;
        }
    }

    public Product select(int id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM products WHERE id = " + id;
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPicturePath(result.getString("picture_path"));
                product.setCategoryId(result.getInt("category_id"));
                product.setBrandId(result.getInt("brand_id"));

                return product;
            }
            return null;
        }
    }
}
