package org.example.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.sql.DeleteClass;
import org.example.sql.QueryClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;


public class MainFxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> list;

    @FXML
    private Button add_new_recording;

    @FXML
    private Button upd;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    private TextArea inf;

    @FXML
    private MenuButton select_table;

    @FXML
    private MenuItem order;

    @FXML
    private MenuItem courier;

    @FXML
    private MenuItem sender;

    @FXML
    private MenuItem recipient;

    @FXML
    private MenuItem pack;

    @FXML
    private MenuItem warehouse;

    @FXML
    private MenuItem employers;



    public ObservableList<String> tableList = FXCollections.observableArrayList();

    private static int chooseId;
    private static String tableName;
    private static char idDep;
    private static char idProj;
    private static boolean clickedEmp;
    private static boolean clickedDep;
    private static final boolean clickedProj = false;


    public static int getChooseId() {
        return chooseId;
    }

    public static char getIdDep() {
        return idDep;
    }

    public static char getIdProj() {
        return idProj;
    }

    @FXML
    void initialize() {


        add_new_recording.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                switch (tableName) {
                    case "Сотрудники":


                        break;
                    case "Заказ":

                        break;
                    case "Курьер":

                        try {
                            Courier.check = false;
                            App.addScene("courier.fxml", 350, 600);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case "Отправители":

                        break;
                    case "Получатель":

                        break;
                    case "Посылка":

                        break;
                    case "Склад":

                        break;

                }
            }
        });

        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                switch (tableName) {
                    case "Сотрудники":


                        break;
                    case "Заказ":
                        DeleteClass.deleteFromOrder(chooseId);

                        break;
                    case "Курьер":

                        break;
                    case "Отправители":

                        break;
                    case "Получатель":

                        break;
                    case "Посылка":

                        break;
                    case "Склад":

                        break;

                }
            }
        });

        upd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                switch (tableName) {
                    case "Сотрудники":


                        break;
                    case "Заказ":

                        break;
                    case "Курьер":

                        try {
                            Courier.check = true;
                            App.addScene("courier.fxml", 350, 600);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case "Отправители":

                        break;
                    case "Получатель":

                        break;
                    case "Посылка":

                        break;
                    case "Склад":

                        break;

                }
            }
        });

        itemAction();
        updateEmpList();
    }

    public void setList(String table) {

        tableList.removeAll(tableList);

        tableName = table;
        System.out.println(tableName + " - TAAAAAABLE");

        switch (table) {
            case "Сотрудники":
                tableList.addAll(QueryClass.getNamesOfEmp(table, -1));
                select_table.setText(employers.getText());
                list.setItems(tableList);
                break;
            case "Заказ":
                tableList.addAll(QueryClass.getOrder(table, -1));
                select_table.setText("Заказ");
                list.setItems(tableList);
                break;
            case "Курьер":
                tableList.addAll(QueryClass.getCourier(table, -1));
                select_table.setText("Курьер");
                list.setItems(tableList);
                break;
            case "Отправители":
                tableList.addAll(QueryClass.getSender(table, -1));
                select_table.setText("Отправители");
                list.setItems(tableList);
                break;
            case "Получатель":
                tableList.addAll(QueryClass.getRecipient(table, -1));
                select_table.setText("Получатель");
                list.setItems(tableList);
                break;
            case "Посылка":
                tableList.addAll(QueryClass.getPack(table, -1));
                select_table.setText("Посылка");
                list.setItems(tableList);
                break;
            case "Склад":
                tableList.addAll(QueryClass.getWarehouse(table, -1));
                select_table.setText("Склад");
                list.setItems(tableList);
                break;


        }


    }

    public void itemAction () {

        order.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Заказ");
            }
        });

        recipient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Получатель");
            }
        });

        sender.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Отправители");
            }
        });

        warehouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Склад");
            }
        });

        courier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Курьер");
            }
        });

        pack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Посылка");
            }
        });

        employers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setList("Сотрудники");
            }
        });

    }


    private void updateEmpList() {

        list.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    try {
                        String str;

                        try {
                            str = String.valueOf(new_val.charAt(0)) + String.valueOf(new_val.charAt(1));
                            chooseId = Integer.parseInt(str);
                        } catch (NumberFormatException e) {
                            chooseId = Integer.parseInt(String.valueOf(new_val.charAt(0)));
                        }

                        inf.setEditable(false);

                        switch (tableName) {
                            case "Сотрудники":
                                inf.setText(String.valueOf(QueryClass.getNamesOfEmp(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                            case "Заказ":
                                inf.setText(String.valueOf(QueryClass.getOrder(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                            case "Курьер":
                                inf.setText(String.valueOf(QueryClass.getCourier(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                            case "Отправители":
                                inf.setText(String.valueOf(QueryClass.getSender(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                            case "Получатель":
                                inf.setText(String.valueOf(QueryClass.getRecipient(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                            case "Посылка":
                                inf.setText(String.valueOf(QueryClass.getPack(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                            case "Склад":
                                inf.setText(String.valueOf(QueryClass.getWarehouse(tableName, chooseId))
                                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
                                break;
                        }

                    } catch (NullPointerException e) {

                    }
                    clickedEmp = true;
                });

    }

}
