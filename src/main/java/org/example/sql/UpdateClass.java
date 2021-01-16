package org.example.sql;

import org.example.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void updateEmpInf(int emp_id, String secondName, String name, String fatherName, String dateOfBirth) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Сотрудники SET Фамилия = " + "'" + secondName + "', Имя = '" + name + "', Отчество = '" +
                                    fatherName + "', Дата_рождения = '" + dateOfBirth + "'" +  "WHERE Код_сотрудника ="  + emp_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOrder(int order_id, int sender, int recipient, int emp, int thePackage) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Заказ SET Код_отправителя = "  + sender + ", Код_получателя = " +
                            recipient + ", Код_сотрудника = " +  emp + ", Код_посылки = "
                            +  thePackage + " WHERE Код_заказа = " + order_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateWarehouse(int warehouse_id, String warehouseName) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Склад SET Наименование = " + "'" + warehouseName + "'" + " WHERE Код_склада = " + warehouse_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateCourier(int courier_id, int houseNumber, int entrance,
                                  int apartmentNumber, String fullName) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Курьер SET Номер_дома = " + houseNumber +
                            ", Номер_подъезда = " + entrance + ", Номер_квартиры = "
                            + apartmentNumber + ", ФИО = '" +  fullName  + "' WHERE Код_курьера = " + courier_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTheSender(int sender_id, String fullName) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Отправители SET ФИО = " + "'" + fullName + "'"
                            + " WHERE Код_отправителя = " + sender_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTheRecipient(int recipient_id, String secondName, String name, String fatherName,
                                    String streetName, int houseNumber, int entrance, int apartmentNumber,
                                    int courier_id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Получатель SET Фамилия = " + "'" + secondName + "'" + ", Имя = " +
                            "'" + name + "'" + ", Отчество = " + "'" + fatherName+ "'" + ", Название_улицы = "
                            + "'" + streetName + "', Номер_дома = " + houseNumber + ", Номер_подъезда = " + entrance +
                            ", Номер_квартиры = " + apartmentNumber + ", Код_курьера = " + courier_id +
                            " WHERE Код_получателя = " + recipient_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateThePackage(int package_id, int sender_id, int warehouse_id, int weight) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Посылка SET Код_отправителя = " + sender_id + ", Код_склада = "
                            + warehouse_id + ", Вес_посылки_кг = " + weight + " WHERE Код_посылки = " + package_id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
