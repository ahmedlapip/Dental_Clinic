package com.project.dental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.scene.image.Image;


import java.awt.*;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Correct path to FXML file
        URL fxmlLocation = getClass().getResource("/com/project/dental/Patient.fxml");

        // Ensure the FXML file is found
        if (fxmlLocation == null) {
            throw new RuntimeException("FXML file not found: /com/project/dental/Patient.fxml");
        }
        Image icon=new Image("/tooth.png") ;

        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load(); // Load the root from FXML

        // Set the scene with the loaded root
        Scene scene = new Scene(root);

        // Set up the stage
        stage.setScene(scene);
        stage.setTitle("Patient Management");
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}