package com.project.dental.Patient;
import com.project.dental.Clinic.*;

public class Patient extends User {
protected String patientHistory, age, gender, bloodType;
protected float weight, height;
protected int ID=0;
public static int cnt=0;


    ///login
    public Patient (String userName,String password ){
        super(userName,password);
        cnt++;
        ID=cnt;
    }

    ///basic info
    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber){

    super(firstName, lastName, username, email, password, mobileNumber);
   }

    ///full info
    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber, String age, String gender, float weight, float height){

        super(firstName, lastName, username, email, password, mobileNumber);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }
    public String getPatientHistory(String patientHistory) {
       return patientHistory;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public void setReservation( String Date, String Time , String Cause){


    }

}