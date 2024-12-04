package com.project.dental.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceanController implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private TextField AgeTextField;
    int age;
    @FXML
    private TextField HeightTextField;
    double Height;
    @FXML
    private TextField WeightTextField;
    Double Weight;
    @FXML
    private ChoiceBox <String> ganderChoiceBox, FromChoiceBox, ToChoiceBox;

    public void SwitchToLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToLoginAsDoctor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginAsDoctor.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToLoginAsPatient(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginAsPatient.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToLoginAsReceptionist(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginAsReceptionist.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToSignup(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signup.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSignupAsDoctor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignupAsDoctor.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSignupAsPatient(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignupAsPatient.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSignupAsReceptionist(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignupAsReceptionist.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToDoctor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Doctor.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToPatient(ActionEvent event) throws IOException {
        try {
            age = Integer.parseInt(AgeTextField.getText());
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wrong Age");
            alert.setHeaderText("Please Enter Numbers Only");
            if (alert.showAndWait().get() == ButtonType.OK) {
                stage.close();
            }
        }
        try {
            Height = Double.parseDouble(HeightTextField.getText());
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wrong Height");
            alert.setHeaderText("Please Enter Numbers Only");
            if (alert.showAndWait().get() == ButtonType.OK) {
                stage.close();
            }
        }
        try {
            Weight = Double.parseDouble(WeightTextField.getText());
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wrong Height");
            alert.setHeaderText("Please Enter Numbers Only");
            if (alert.showAndWait().get() == ButtonType.OK) {
                stage.close();
            }
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Patient.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToReceptionist(ActionEvent event) throws IOException {
        try {
            age = Integer.parseInt(AgeTextField.getText());
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wrong Age");
            alert.setHeaderText("Please Enter Numbers Only");
            if (alert.showAndWait().get() == ButtonType.OK) {
                stage.close();
            }
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Receptionist.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToDentalClinic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dental_Clinic.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ganderChoiceBox != null) {
            ganderChoiceBox.getItems().addAll("Male", "Female");
        } else {
            System.err.println("ganderChoiceBox is null. Check FXML and controller setup.");
        }
        if (FromChoiceBox != null) {
            FromChoiceBox.getItems().addAll("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        } else {
            System.err.println("ganderChoiceBox is null. Check FXML and controller setup.");
        }
        if (ToChoiceBox != null) {
            ToChoiceBox.getItems().addAll("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        } else {
            System.err.println("ganderChoiceBox is null. Check FXML and controller setup.");
        }
    }
}


