package com.project.dental.Patient;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

import java.time.LocalDate;

public class PatientController {
    // Update Details
    @FXML private TextField emailField;
    @FXML private TextField mobileField;
    @FXML private TextField weightField;
    @FXML private TextField heightField;

    // Reserve Appointment
    @FXML private DatePicker appointmentDatePicker;
    @FXML private ComboBox<String> timeComboBox;

    // Cancel Reservation
    @FXML private TextField reservationIdField;

    // Check Prices
    @FXML private TableView<String> pricesTable;

    // Search Doctor
    @FXML private TextField searchField;
    @FXML private TableView<String> doctorSearchResultsTable;

    // Display Available Appointments
    @FXML private TableView<String> availableAppointmentsTable;

    @FXML
    public void initialize() {
        // Populate time combo box with example time slots
        timeComboBox.setItems(FXCollections.observableArrayList("9:00 AM", "10:00 AM", "11:00 AM", "2:00 PM", "3:00 PM","4:00PM"));

        // Populate example data for prices and available appointments
        loadExamplePrices();
        loadExampleAppointments();
    }

    private void loadExamplePrices() {
        // Add example data for appointment prices
        // Replace with actual data fetching
    }

    private void loadExampleAppointments() {
        // Add example data for available appointments
        // Replace with actual data fetching
    }

    @FXML
    public void updateDetails() {
        String email = emailField.getText();
        String mobile = mobileField.getText();
        String weight = weightField.getText();
        String height = heightField.getText();

        if (email.isEmpty() || mobile.isEmpty() || weight.isEmpty() || height.isEmpty()) {
            showAlert("Error", "Please fill out all fields to update your details.", Alert.AlertType.ERROR);
            return;
        }
        showAlert("Success", "Your details have been updated!", Alert.AlertType.INFORMATION);
    }

    @FXML
    public void reserveAppointment() {
        LocalDate date = appointmentDatePicker.getValue();
        String time = timeComboBox.getValue();

        if (date == null || time == null) {
            showAlert("Error", "Please select a date and time to reserve an appointment.", Alert.AlertType.ERROR);
            return;
        }

        // Reserve the appointment (replace with database logic)
        System.out.printf("Appointment reserved: Date=%s, Time=%s%n", date, time);
        showAlert("Success", "Your appointment has been reserved!", Alert.AlertType.INFORMATION);
    }

    @FXML
    public void cancelReservation() {
        String reservationId = reservationIdField.getText();

        if (reservationId.isEmpty()) {
            showAlert("Error", "Please enter a reservation ID.", Alert.AlertType.ERROR);
            return;
        }

        // Cancel the reservation (replace with database logic)
        System.out.printf("Reservation canceled: ID=%s%n", reservationId);
        showAlert("Success", "Your reservation has been canceled!", Alert.AlertType.INFORMATION);
    }

    @FXML
    public void searchDoctor() {
        String query = searchField.getText();

        if (query.isEmpty()) {
            showAlert("Error", "Please enter a name or mobile number to search for a doctor.", Alert.AlertType.ERROR);
            return;
        }
        else

        // Search for doctors by name or mobile (replace with database logic)
        System.out.printf("Searching for doctor: Query=%s%n", query);
    }

    // Utility function to show alerts
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
