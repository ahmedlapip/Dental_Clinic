package com.project.dental.Receptionist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReceptionistDashboardController {

    @FXML
    private TextField emailField, mobileField, weightField, heightField;

    @FXML
    private TextField patientNameField;

    @FXML
    private DatePicker appointmentDatePicker;

    @FXML
    private ListView<String> appointmentsList;

    private ObservableList<String> appointments = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize appointments list
        appointmentsList.setItems(appointments);
    }

    @FXML
    private void saveDetails() {
        String email = emailField.getText();
        String mobile = mobileField.getText();
        String weight = weightField.getText();
        String height = heightField.getText();

        // Save the details (implement file or database logic here)
        System.out.println("Saved Details:");
        System.out.println("Email: " + email + ", Mobile: " + mobile + ", Weight: " + weight + ", Height: " + height);
    }

    @FXML
    private void reserveAppointment() {
        String patientName = patientNameField.getText();
        String appointmentDate = appointmentDatePicker.getValue() != null ? appointmentDatePicker.getValue().toString() : null;

        if (patientName != null && !patientName.isEmpty() && appointmentDate != null) {
            String appointment = patientName + " - " + appointmentDate;
            appointments.add(appointment);
            System.out.println("Reserved Appointment: " + appointment);
        } else {
            System.out.println("Invalid input for appointment reservation.");
        }
    }

    @FXML
    private void cancelAppointment() {
        String selectedAppointment = appointmentsList.getSelectionModel().getSelectedItem();

        if (selectedAppointment != null) {
            appointments.remove(selectedAppointment);
            System.out.println("Cancelled Appointment: " + selectedAppointment);
        } else {
            System.out.println("No appointment selected.");
        }
    }
}

