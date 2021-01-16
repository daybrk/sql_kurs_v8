package org.example.sql;

import org.example.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromOrder(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Заказ WHERE [Код_заказа] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromCourier(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Курьер WHERE [Код_курьера] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromEmp(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Сотрудники WHERE [Код_сотрудника] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromSender(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Отправители WHERE [Код_отправителя] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    static int depId;
    static String pro;

    public static void deleteFromRecipient(int id) {


        try {
            Statement stmt = connection.createStatement();

            stmt.execute("DELETE FROM Получатель WHERE [Код_получателя] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromWarehouse(int id) {

        try {
            Statement stmt = connection.createStatement();

            stmt.execute("DELETE FROM Склад WHERE [Код_склада] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromPackage(int id) {

        try {
            Statement stmt = connection.createStatement();

            stmt.execute("DELETE FROM Посылка WHERE [Код_посылки] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

}
