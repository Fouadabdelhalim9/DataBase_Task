package org.repos;

import org.common.DBConnectionManager;
import org.entities.Branch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BranchRepository {
    private DBConnectionManager connectionManager = new DBConnectionManager();

    public int insert(Branch branch) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "INSERT INTO branches (name, building, street_name, working_start, working_end, telephone, zone_id) "
                    + "VALUES ('" + branch.getName() + "', '" + branch.getBuilding() + "', '" + branch.getStreetName() + "', '"
                    + branch.getWorkingStartTime() + "', '" + branch.getWorkingEndTime() + "', '" + branch.getTelephone() + "', '"
                    + branch.getZoneId() + "')";

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int update(Branch branch) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "UPDATE branches SET "
                    + "name = '" + branch.getName() + "', "
                    + "building = '" + branch.getBuilding() + "', "
                    + "street_name = '" + branch.getStreetName() + "', "
                    + "working_start = '" + branch.getWorkingStartTime() + "', "
                    + "working_end = '" + branch.getWorkingEndTime() + "', "
                    + "telephone = '" + branch.getTelephone() + "', "
                    + "zone_id = '" + branch.getZoneId() + "' "
                    + "WHERE id = " + branch.getId();

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public int delete(Integer id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "DELETE FROM branches "
                    + "WHERE id = " + id;

            int noOfRowsAffected = stmt.executeUpdate(sqlQuery);
            System.out.println(noOfRowsAffected);

            return noOfRowsAffected;
        }
    }

    public List<Branch> selectAll() throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM branches";
            ResultSet result = stmt.executeQuery(sqlQuery);

            List<Branch> allBranches = new ArrayList<>();
            while (result.next()) {
                Branch branch = new Branch();
                branch.setId(result.getInt("id"));
                branch.setName(result.getString("name"));
                branch.setBuilding(result.getString("building"));
                branch.setStreetName(result.getString("street_name"));
                branch.setWorkingStartTime(result.getTime("working_start"));
                branch.setWorkingEndTime(result.getTime("working_end"));
                branch.setTelephone(result.getString("telephone"));
                branch.setZoneId(result.getInt("zone_id"));

                allBranches.add(branch);
            }
            return allBranches;
        }
    }

    public Branch select(int id) throws ClassNotFoundException, SQLException {
        try (
                Connection connection = connectionManager.connect();
                Statement stmt = connection.createStatement();) {
            String sqlQuery = "SELECT * FROM branches WHERE id = " + id;
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                Branch branch = new Branch();
                branch.setId(result.getInt("id"));
                branch.setName(result.getString("name"));
                branch.setBuilding(result.getString("building"));
                branch.setStreetName(result.getString("street_name"));
                branch.setWorkingStartTime(result.getTime("working_start"));
                branch.setWorkingEndTime(result.getTime("working_end"));
                branch.setTelephone(result.getString("telephone"));
                branch.setZoneId(result.getInt("zone_id"));

                return branch;
            }
            return null;
        }
    }
}
