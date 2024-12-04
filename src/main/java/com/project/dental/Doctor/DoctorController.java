package com.project.dental.Doctor;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DoctorController {
    // Prescription Tab
    @FXML private TextField patientNameField;
    @FXML private TableView<String> medicationsTable;
    @FXML private TextField medicationField;
    @FXML private TextField dosageField;
    @FXML private TextArea instructionsArea;
    @FXML private DatePicker datePicker;
    private ObservableList<String> medications = FXCollections.observableArrayList();

    // Appointments Tab
    @FXML private DatePicker appointmentDatePicker;
    @FXML private TableView<String> appointmentsTable;

    // Receptionist Info Tab
    @FXML private TextArea receptionistInfoArea;

    // Patient Info Tab
    @FXML private TextField patientIdField;
    @FXML private TextArea patientInfoArea;

    // Change Availability Tab
    @FXML private ComboBox<String> availabilityComboBox;
    @FXML private TextArea currentAvailabilityArea;

    @FXML
    public void initialize() {
        // Initialize the medications table
        medicationsTable.setItems(medications);

        // Initialize availability options
        availabilityComboBox.setItems(FXCollections.observableArrayList("Available", "Unavailable"));
    }

    // Prescription Tab Handlers
    @FXML
    public void addMedication() {
        String medication = medicationField.getText();
        if (!medication.isEmpty()) {
            medications.add(medication);
            medicationField.clear();
        }
    }

    @FXML
    public void savePrescription() {
        // Logic to save the prescription
    }

    // Appointments Tab Handlers
    @FXML
    public void viewAppointments() {
        // Logic to fetch and display appointments for the selected date
    }

    // Receptionist Info Tab Handlers
    @FXML
    public void refreshReceptionistInfo() {
        // Logic to fetch and display receptionist contact information
    }

    // Patient Info Tab Handlers
    @FXML
    public void getPatientInfo() {
        // Logic to fetch and display patient information based on ID
    }

    // Change Availability Tab Handlers
    @FXML
    public void updateAvailability() {
        String selectedAvailability = availabilityComboBox.getValue();
        if (selectedAvailability != null) {
            currentAvailabilityArea.setText("Doctor is now: " + selectedAvailability);
            // Save the availability status in the database or a file
        }
    }
}

