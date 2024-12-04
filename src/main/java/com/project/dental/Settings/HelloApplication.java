package com.project.dental.Settings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dental_Clinic.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        Image icon = new Image("dentist.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Dental Clinic");
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });

        SceanController controller = fxmlLoader.getController();
        scene.setOnKeyPressed(event -> {
            if (Objects.requireNonNull(event.getCode()) == KeyCode.ESCAPE) {
                exit(stage);
            }
        });

    }


    public static void main(String[] args) {
        launch();
    }
    public void exit(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("exit");
        alert.setHeaderText("You're About To Exit From The Program!");
            if (alert.showAndWait().get() == ButtonType.OK) {
                stage.close();
            }
    }





}