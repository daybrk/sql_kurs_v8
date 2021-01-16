package org.example.sql;

import org.example.ConnectDB;
import org.example.QueryStrings;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Boolean addNewOrder(int order_id, int sender, int recipient, int emp, int thePackage) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewOrder +
                    " VALUES (" + order_id + "," + sender + "," + recipient + ","  + emp + "," + thePackage + ")");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewOrder");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Boolean addNewWarehouse(int warehouse_id, String warehouseName) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewWarehouse +
                    " VALUES (" + warehouse_id + ",'" + warehouseName + "')");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewWarehouse");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Boolean addNewCourier(int courier_id, int houseNumber, int entrance,
                                        int apartmentNumber, String fullName) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewCourier +
                    " VALUES (" + courier_id + "," + houseNumber + "," + entrance + "," + apartmentNumber + ",'" + fullName + "')");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewCourier");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void addNewTheSender(int sender_id, String fullName) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewTheSender +
                    "VALUES (" + sender_id + ",'" + fullName + "')");

            stmt.close();
        } catch (SQLException  e) {
            System.out.println("Error: addNewTheSender");
            e.printStackTrace();
        }
    }

    public static void addNewTheRecipient(int recipient_id, String secondName, String name, String fatherName,
                                          String streetName, int houseNumber, int entrance, int apartmentNumber,
                                          int courier_id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewTheRecipient +
                    "VALUES (" + recipient_id + ",'" + secondName +"','" + name + "','" + fatherName + "','" + streetName + "',"
                    + houseNumber + "," + entrance + "," + apartmentNumber + "," + courier_id + ")");

            stmt.close();
        } catch (SQLException  e) {
            System.out.println("Error: addNewTheRecipient");
            e.printStackTrace();
        }
    }

    public static void addNewThePackage(int package_id, int sender_id, int warehouse_id, int weight) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewThePackage +
                    "VALUES (" + package_id + "," + sender_id + "," + warehouse_id + "," + weight + ")");

            stmt.close();
        } catch (SQLException  e) {
            System.out.println("Error: addNewThePackage");
            e.printStackTrace();
        }
    }

    public static void addNewEmployer(int emp_id, String secondName, String name, String fatherName, String dateOfBirth) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewEmployer +
                    "VALUES (" + emp_id  + ",'" + secondName + "','" + name + "','" + fatherName + "','" + dateOfBirth + "')");

            stmt.close();
        } catch (SQLException  e) {
            System.out.println("Error: addNewEmployer");
            e.printStackTrace();
        }
    }

}
