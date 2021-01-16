package org.example.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.ConnectDB;
import org.example.sql.InsertClass;
import org.example.sql.QueryClass;
import org.example.sql.UpdateClass;

public class Courier {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField num_home;

    @FXML
    private TextField num_ent;

    @FXML
    private TextField num_app;

    @FXML
    private TextField fullName;

    @FXML
    private Button button;

    public static boolean check = false;

    public static int id;

    public static  ArrayList<String> arrayList;

    @FXML
    void initialize() {

        id = Integer.parseInt(String.valueOf(MainFxmlController.getChooseId()));
        if (check){
            
            btn();
        }

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (!check) {
                    InsertClass.addNewCourier(ConnectDB.maxCourId, Integer.parseInt(num_home.getText()),
                            Integer.parseInt(num_ent.getText()), Integer.parseInt(num_app.getText()), fullName.getText());
                } else {

                    UpdateClass.updateCourier(id, Integer.parseInt(num_home.getText()), Integer.parseInt(num_ent.getText()),
                            Integer.parseInt(num_app.getText()), fullName.getText());

                    check = false;
                }

            }
        });

    }

    public void btn () {

        arrayList = new ArrayList<>();

        arrayList = QueryClass.getCourier("Курьер", id);
        System.out.println(arrayList);

        num_home.setText(arrayList.get(1));
        num_ent.setText(arrayList.get(3));
        num_app.setText(arrayList.get(5));
        fullName.setText(arrayList.get(7));
    }
}
