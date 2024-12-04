package com.project.dental.Settings;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Login {
    @FXML
    private ComboBox<String> login_menu;
     public Login() {

     }
     public void initialize() {
         login_menu.setItems(FXCollections.observableArrayList("Doctor","Patient","Receptionist"));
     }


}
