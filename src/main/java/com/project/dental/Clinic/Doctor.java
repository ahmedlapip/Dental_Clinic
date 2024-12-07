package com.project.dental.Clinic;

import com.project.dental.Clinic.User;
import com.project.dental.Patient.Patient;
import com.project.dental.Receptionist.Receptionist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Doctor extends User {
    private String doctorName;
    private String specialization;
    private ArrayList<ArrayList<Integer>> dayHours = new ArrayList<>();
    private final Vector<Pair<LocalDate, Integer>> appointments = new Vector<>();
    private final List<List<Prescription>> patientPrescriptions = new ArrayList<>();
    private final String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    // Constructor
    public Doctor(String firstName, String lastName, String username, String email, String password, String mobileNumber, String specialization) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.doctorName = firstName + " " + lastName;
        this.specialization = specialization;
        initializeSchedule();
    }

    // Initialize dayHours
    private void initializeSchedule() {
        for (int i = 0; i < 7; i++) {
            dayHours.add(new ArrayList<>());
        }
    }

    // Set the schedule for a specific day
    public void setSchedule(String day, int startHour, int endHour) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Invalid day: " + day);
            return;
        }

        if (startHour >= endHour || startHour < 0 || endHour > 24) {
            System.out.println("Invalid working hours. Please provide valid start and end times.");
            return;
        }

        // Populate working hours
        ArrayList<Integer> workingHours = new ArrayList<>();
        for (int hour = startHour; hour < endHour; hour++) {
            workingHours.add(hour);
        }
        dayHours.set(dayIndex, workingHours); // Update dayHours
        System.out.println("Schedule set for " + day + ": " + startHour + " to " + endHour);
    }

    // Set an appointment
    public void setAppointment(String day, int hour, LocalDate date) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Invalid day: " + day);
            return;
        }

        ArrayList<Integer> dayWorkingHours = dayHours.get(dayIndex);
        if (!dayWorkingHours.contains(hour)) {
            System.out.println("Invalid appointment time: " + hour + " on " + day + " (outside working hours)");
            return;
        }

        Pair<LocalDate, Integer> appointment = new Pair<>(date, hour);
        if (appointments.contains(appointment)) {
            System.out.println("Cannot schedule an appointment at " + hour + ":00 on " + date + " (already booked)");
            return;
        }

        appointments.add(appointment);
        System.out.println("Appointment scheduled at " + hour + ":00 on " + date);
    }

    public String getDoctorName() {

        return doctorName;
    }

    public void initializePatients(int patientCount) {
        for (int i = 0; i < patientCount; i++) {
            patientPrescriptions.add(new ArrayList<>());
        }
    }

    // Show appointments for a specific date
    public void showAppointments(LocalDate date) {
        boolean hasAppointments = false;
        System.out.println("Appointments for " + date + ":");
        for (Pair<LocalDate, Integer> appointment : appointments) {
            if (appointment.getKey().equals(date)) {
                System.out.println("- " + appointment.getValue() + ":00");
                hasAppointments = true;
            }
        }
        if (!hasAppointments) {
            System.out.println("No appointments for " + date);
        }
    }

    // Get day index from the name
    private int getDayIndex(String day) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].equalsIgnoreCase(day)) {
                return i;
            }
        }
        return -1; // Invalid day
    }

    // Add a prescription for a patient
    public void addPrescription(int patientIndex, String medicine, String notes) {
        if (patientIndex < 0 || patientIndex >= patientPrescriptions.size()) {
            System.out.println("Invalid patient index: " + patientIndex);
            return;
        }
        Prescription prescription = new Prescription(this.doctorName);
        prescription.writePrescription(medicine, notes);
        patientPrescriptions.get(patientIndex).add(prescription);
        System.out.println("Prescription added for patient " + (patientIndex + 1));
    }

    // View prescriptions for a patient
    public void viewPrescriptions(int patientIndex) {
        if (patientIndex < 0 || patientIndex >= patientPrescriptions.size()) {
            System.out.println("Invalid patient index: " + patientIndex);
            return;
        }
        List<Prescription> prescriptions = patientPrescriptions.get(patientIndex);
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions for patient " + (patientIndex + 1));
        } else {
            System.out.println("Prescriptions for patient " + (patientIndex + 1) + ":");
            for (Prescription prescription : prescriptions) {
                prescription.printPrescription();
            }
        }
    }

    public void receptionistContactInfo(Receptionist receptionist) {
        System.out.println("Receptionist Name: " + receptionist.getName());
        System.out.println("Receptionist Email: " + receptionist.getEmail());
        System.out.println("Receptionist Contact: " + receptionist.getContact());
    }

    public void patientInfo(Patient patient) {
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Patient Age: " + patient.getAge());
        System.out.println("Patient Email: " + patient.getEmail());
        System.out.println("Patient Contact: " + patient.getContact());
    }

    // Prescription class
    public static class Prescription {
        private final String doctorName;
        private final Vector<Pair<String, String>> prescriptions = new Vector<>();

        public Prescription(String doctorName) {
            this.doctorName = doctorName;
        }

        public void writePrescription(String medicine, String notes) {
            prescriptions.add(new Pair<>(medicine, notes));
        }

        public void printPrescription() {
            System.out.println("Doctor: " + doctorName);
            System.out.println("Prescriptions:");
            for (Pair<String, String> entry : prescriptions) {
                System.out.println(" - Medicine: " + entry.getKey() + ", Notes: " + entry.getValue());
            }
        }
    }

    // Pair utility class
    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
