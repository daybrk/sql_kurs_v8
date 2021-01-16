package org.example.sql;

import org.example.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getNamesOfEmp(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> name = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {

                    stringBuilder.append(executeQuery.getString("Код_сотрудника"));
                    stringBuilder.append(" ");
                    stringBuilder.append(executeQuery.getString("Фамилия"));
                    stringBuilder.append(" ");
                    stringBuilder.append(executeQuery.getString("Имя"));
                    stringBuilder.append(" ");
                    stringBuilder.append(executeQuery.getString("Отчество"));

                    name.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();
                }

            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_сотрудника").equals(String.valueOf(id))) {

                        stringBuilder.append("Фамилия: ");
                        stringBuilder.append(executeQuery.getString("Фамилия"));
                        stringBuilder.append("\nИмя: ");
                        stringBuilder.append(executeQuery.getString("Имя"));
                        stringBuilder.append("\nОтчество: ");
                        stringBuilder.append(executeQuery.getString("Отчество"));
                        stringBuilder.append("\nДата рождения: ");
                        stringBuilder.append(executeQuery.getString("Дата_рождения"));

                        name.add(String.valueOf(stringBuilder));

                    }
                }

            }

            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }


    public static ArrayList<String> getOrder(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {

                    stringBuilder.append(executeQuery.getInt("Код_заказа"));
                    stringBuilder.append("- Код заказа");

                    proj.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();
                }
            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_заказа").equals(String.valueOf(id))) {

                        stringBuilder.append("Код отправителя: ");
                        stringBuilder.append(executeQuery.getString("Код_отправителя"));
                        stringBuilder.append("\nКод получателя: ");
                        stringBuilder.append(executeQuery.getString("Код_получателя"));
                        stringBuilder.append("\nКод сотрудника: ");
                        stringBuilder.append(executeQuery.getString("Код_сотрудника"));
                        stringBuilder.append("\nКод посылки: ");
                        stringBuilder.append(executeQuery.getString("Код_посылки"));
                        proj.add(String.valueOf(stringBuilder));
                    }
                }
            }

            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static ArrayList<String> getCourier(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {

                    stringBuilder.append(executeQuery.getInt("Код_курьера"));
                    stringBuilder.append(" - Код курьера");
                    proj.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();
                }

            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_курьера").equals(String.valueOf(id))) {

                        stringBuilder.append("Номер дома: ");
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append(executeQuery.getString("Номер_дома"));
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append("\nНомер подъезда: ");
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append(executeQuery.getString("Номер_подъезда"));
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append("\nНомер квартиры: ");
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append(executeQuery.getString("Номер_квартиры"));
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append("\nФИО: ");
                        proj.add(String.valueOf(stringBuilder));
                        stringBuilder = new StringBuilder();

                        stringBuilder.append(executeQuery.getString("ФИО"));
                        proj.add(String.valueOf(stringBuilder));
                    }
                }
            }
            executeQuery.close();
            stmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static ArrayList<String> getSender(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {

                    stringBuilder.append(executeQuery.getInt("Код_отправителя"));
                    stringBuilder.append(" - Код отправителя");
                    proj.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();

                }
            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_отправителя").equals(String.valueOf(id))) {

                        stringBuilder.append("ФИО: ");
                        stringBuilder.append(executeQuery.getString("ФИО"));
                        proj.add(String.valueOf(stringBuilder));
                    }
                }
            }

            executeQuery.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static ArrayList<String> getRecipient(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {

                    stringBuilder.append(executeQuery.getInt("Код_получателя"));
                    stringBuilder.append(" ");
                    stringBuilder.append(executeQuery.getString("Фамилия"));
                    stringBuilder.append(" ");
                    stringBuilder.append(executeQuery.getString("Имя"));
                    stringBuilder.append(" ");
                    stringBuilder.append(executeQuery.getString("Отчество"));

                    proj.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();
                }
            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_получателя").equals(String.valueOf(id))) {

                        stringBuilder.append("Название улицы: ");
                        stringBuilder.append(executeQuery.getString("Название_улицы"));
                        stringBuilder.append("\nНомер дома: ");
                        stringBuilder.append(executeQuery.getString("Номер_дома"));
                        stringBuilder.append("\nНомер подъезда: ");
                        stringBuilder.append(executeQuery.getString("Номер_подъезда"));
                        stringBuilder.append("\nНомер квартиры: ");
                        stringBuilder.append(executeQuery.getString("Номер_квартиры"));
                        stringBuilder.append("\nКод курьера: ");
                        stringBuilder.append(executeQuery.getString("Код_курьера"));
                        proj.add(String.valueOf(stringBuilder));
                    }
                }
            }
            executeQuery.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static ArrayList<String> getWarehouse(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {
                    stringBuilder.append(executeQuery.getInt("Код_склада"));
                    stringBuilder.append(" - Код склада");
                    proj.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();
                }

            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_склада").equals(String.valueOf(id))) {

                        stringBuilder.append("Наименование склада: ");
                        stringBuilder.append(executeQuery.getString("Наименование"));
                        proj.add(String.valueOf(stringBuilder));
                    }
                }
            }

            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static ArrayList<String> getPack(String table, int id) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            if (id == -1) {

                while (executeQuery.next()) {
                    stringBuilder.append(executeQuery.getInt("Код_посылки"));
                    stringBuilder.append(" - Код посылки");
                    proj.add(String.valueOf(stringBuilder));
                    stringBuilder = new StringBuilder();
                }

            } else if (id > 0) {

                while (executeQuery.next()) {

                    if (executeQuery.getString("Код_посылки").equals(String.valueOf(id))) {

                        stringBuilder.append("Код отправителя: ");
                        stringBuilder.append(executeQuery.getString("Код_отправителя"));
                        stringBuilder.append("\nКод склада: ");
                        stringBuilder.append(executeQuery.getString("Код_склада"));
                        stringBuilder.append("\nВес посылки в кг: ");
                        stringBuilder.append(executeQuery.getString("Вес_посылки_кг"));
                        proj.add(String.valueOf(stringBuilder));
                    }
                }
            }

            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

}



