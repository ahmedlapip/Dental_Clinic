package Clinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Doctor extends User {
    private String doctorName;
    private String specialization;
    private int startHour;
    private int endHour;
    private Map<String, ArrayList<Integer>> dayHoursMap;


    public Doctor(String firstName, String lastName, String username, String email, String password, String mobileNumber, String specialization) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.doctorName = firstName + " " + lastName;
        this.specialization = specialization;
        this.dayHoursMap = new HashMap<>();
        initializeSchedule();
    }

    private void initializeSchedule() {
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        for (String day : days) {
            dayHoursMap.put(day, new ArrayList<>());
        }
    }

    public void setSchedule(String day, int startHour, int endHour) {
        if (!dayHoursMap.containsKey(day)) {
            System.out.println("Invalid day: " + day);
            return;
        }
        this.startHour = startHour;
        this.endHour = endHour;
        System.out.println("Schedule set for " + day + ": " + startHour + " to " + endHour);
    }

    public void showAppointments(String day) {
        if (!dayHoursMap.containsKey(day)) {
            System.out.println("Invalid day: " + day);
            return;
        }
        ArrayList<Integer> appointments = dayHoursMap.get(day);
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled for " + day);
        } else {
            System.out.println("Appointments for " + day + ": " + appointments);
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

    public void setAppointment(String day, int hour) {
        if (!dayHoursMap.containsKey(day)) {
            System.out.println("Invalid day: " + day);
            return;
        }

        if (!hourCheck(hour)) {
            return;
        }

        ArrayList<Integer> appointments = dayHoursMap.get(day);
        if (appointments.contains(hour)) {
            System.out.println("Cannot schedule an appointment at " + hour + " (already booked)");
            return;
        }

        appointments.add(hour);
        System.out.println("Appointment scheduled at " + hour + " on " + day);
    }

    public void cancelAppointment(String day, int hour) {
        if (!dayHoursMap.containsKey(day)) {
            System.out.println("Invalid day: " + day);
            return;
        }

        ArrayList<Integer> appointments = dayHoursMap.get(day);
        if (appointments.remove((Integer) hour)) {
            System.out.println("Appointment at " + hour + " on " + day + " has been canceled.");
        } else {
            System.out.println("No appointment found at " + hour + " on " + day);
        }
    }

    public void changeAppointment(String day, int oldHour, int newHour) {
        if (!dayHoursMap.containsKey(day)) {
            System.out.println("Invalid day: " + day);
            return;
        }

        ArrayList<Integer> appointments = dayHoursMap.get(day);

        if (!appointments.contains(oldHour)) {
            System.out.println("No appointment exists at " + oldHour + " on " + day);
            return;
        }

        if (!hourCheck(newHour)) {
            return;
        }

        if (appointments.contains(newHour)) {
            System.out.println("Cannot reschedule to " + newHour + " on " + day + " (already booked)");
            return;
        }

        appointments.remove((Integer) oldHour);
        appointments.add(newHour);
        System.out.println("Appointment changed from " + oldHour + " to " + newHour + " on " + day);
    }

    private boolean hourCheck(int hour) {
        if (hour < startHour || hour >= endHour) {
            System.out.println("Invalid appointment time: " + hour);
            return false;
        }
        return true;
    }

    public static class Prescription {
        private String patientName;
        private String doctorName;
        private ArrayList<String> medicines;
        private String notes;

        public Prescription(String patientName, String doctorName) {
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.medicines = new ArrayList<>();
        }

        public void writePrescription(String medicine, String notes) {
            this.medicines.add(medicine);
            this.notes = notes;
        }

        public void printPrescription() {
            System.out.println("Prescription for " + patientName);
            System.out.println("Doctor: " + doctorName);
            System.out.println("Medicines: " + String.join(", ", medicines));
            System.out.println("Notes: " + notes);
        }
    }

    public void Prescription(Patient patient) {
        // Create a new Prescription object
        Prescription prescription = new Prescription(patient.getName(), this.doctorName);

        // Example of collecting prescription details with error handling
        System.out.println("Writing a prescription for " + patient.getName());
        Scanner scanner = new Scanner(System.in);

        boolean addMore = true;
        try {
            while (addMore) {
                System.out.print("Enter medicine name: ");
                String medicine = scanner.nextLine();

                System.out.print("Enter notes for the medicine: ");
                String notes = scanner.nextLine();

                prescription.writePrescription(medicine, notes);

                System.out.print("Do you want to add another medicine? (yes/no): ");
                String response = scanner.nextLine();
                addMore = response.equalsIgnoreCase("yes");
            }
        } catch (Exception e) {
            System.out.println("Error in prescription input: " + e.getMessage());
        }

        prescription.printPrescription();
    }
}
