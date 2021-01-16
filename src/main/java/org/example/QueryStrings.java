package org.example;

public class QueryStrings {

    public static String addNewCourier =
            "INSERT INTO [Курьер] " +
                    "([Код_курьера], [Номер_дома], [Номер_подъезда], [Номер_квартиры], [ФИО])";

    public static String addNewTheSender =
            "INSERT INTO [Отправители] " +
                    "([Код_отправителя], [ФИО])";

    public static String addNewTheRecipient =
            "INSERT INTO [Получатель] " +
                    "([Код_получателя], [Фамилия], [Имя], [Отчество], [Название_улицы], [Номер_дома], " +
                    "[Номер_подъезда], [Номер_квартиры], [Код_курьера])";

    public static String addNewThePackage =
            "INSERT INTO [Посылка] " +
                    "([Код_посылки], [Код_отправителя], [Код_склада], [Вес_посылки_кг])";

    public static String addNewEmployer =
            "INSERT INTO [Сотрудники] " +
                    "([Код_сотрудника], [Фамилия], [Имя], [Отчество], [Дата_рождения])";

    public static String addNewOrder =
            "INSERT INTO [Заказ] " +
                    "([Код_заказа], [Код_отправителя], [Код_получателя], [Код_сотрудника], [Код_посылки])";

    public static String addNewWarehouse =
            "INSERT INTO [Склад] " +
                    "([Код_склада], [Наименование])";
}
