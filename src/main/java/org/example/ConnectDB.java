package org.example;


import org.example.sql.DeleteClass;
import org.example.sql.InsertClass;
import org.example.sql.UpdateClass;

import java.sql.*;

public class ConnectDB {

    private static String url = "jdbc:sqlserver://DESKTOP-O8NA0U3\\SQLEXPRESS01;database=kursovaya8B;";
    private static Connection connection;
    public static int maxOrderId;
    public static int maxCourId;
    public static int maxSenderId;
    public static int maxRecId;
    public static int maxPackId;
    public static int maxWareId;
    public static int maxEmpId;

    public static String getUrl() {
        return url;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void ex() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(url, "User", "User");
            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT [Код_заказа] FROM Заказ");

            maxOrderId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_заказа"));
                if (maxOrderId < id) {
                    maxOrderId = id;
                }
            }
            maxOrderId++;
            executeQuery.close();


            executeQuery = stmt.executeQuery("SELECT [Код_курьера] FROM Курьер");

            maxCourId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_курьера"));
                if (maxCourId <= id) {
                    maxCourId = id;
                }
                System.out.println(maxCourId + " - AFTER ID");
            }
            maxCourId++;
            System.out.println(maxCourId + " - AFTER ID");

            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT [Код_отправителя] FROM Отправители");

            maxSenderId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_отправителя"));
                if (maxSenderId < id) {
                    maxSenderId = id;
                }
            }
            maxSenderId++;
            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT [Код_получателя] FROM Получатель");

            maxRecId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_получателя"));
                if (maxRecId < id) {
                    maxRecId = id;
                }
            }
            maxRecId++;
            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT [Код_посылки] FROM Посылка");

            maxPackId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_посылки"));
                if (maxPackId < id) {
                    maxPackId = id;
                }
            }
            maxPackId++;
            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT [Код_склада] FROM Склад");

            maxWareId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_склада"));
                if (maxWareId < id) {
                    maxWareId = id;
                }
            }
            maxWareId++;
            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT [Код_сотрудника] FROM Сотрудники");

            maxEmpId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Код_сотрудника"));
                if (maxEmpId < id) {
                    maxEmpId = id;
                }
            }
            maxEmpId++;
            executeQuery.close();

//            InsertClass.addNewEmployer(maxEmpId, "Трофимов", "Илья", "Юрьевич", "2000-07-19");
//            InsertClass.addNewTheSender(maxSenderId, "Трофимов Илья Юрьевич");
//            InsertClass.addNewWarehouse(maxWareId, "Склад имени Ильи");
//            InsertClass.addNewCourier(maxCourId, 6, 1, 20, "Трофимов Илья Юрьевич");
//            InsertClass.addNewThePackage(maxPackId, 1,1, 70);
//            InsertClass.addNewTheRecipient(maxRecId,"Трофимов","Илья", "Юрьевич",
//                    "Побежимова", 6, 1, 20, maxCourId);
//            InsertClass.addNewOrder(maxOrderId, maxSenderId, maxRecId, maxEmpId, maxPackId);
//
//            UpdateClass.updateEmpInf(maxEmpId, "Троимов", "Илья", "Юевич", "2000-07-19");
//            UpdateClass.updateCourier(maxCourId, 6, 2, 1, "Троимов Илья Юевич");
//            UpdateClass.updateThePackage(maxPackId, 1,1, 150);
//            UpdateClass.updateTheRecipient(maxRecId,"Троимов","Илья", "Юевич",
//                    "Побежимова", 6, 2, 1, maxCourId);
//            UpdateClass.updateTheSender(maxSenderId, "Троимов Илья Юевич");
//            UpdateClass.updateWarehouse(maxWareId, "Склад имени И");
//            UpdateClass.updateOrder(maxOrderId, maxSenderId, maxRecId, maxEmpId, maxPackId);

//            DeleteClass.deleteFromOrder(maxOrderId);
//            DeleteClass.deleteFromPackage(maxPackId);
//            DeleteClass.deleteFromRecipient(maxRecId);
//            DeleteClass.deleteFromCourier(maxCourId);
//            DeleteClass.deleteFromWarehouse(maxWareId);
//            DeleteClass.deleteFromSender(maxSenderId);
//            DeleteClass.deleteFromEmp(maxEmpId);






        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

    }

}
