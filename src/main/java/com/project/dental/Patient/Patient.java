package com.project.dental.Patient;

public class Patient {
   protected String Username, Password, FirstName, LastName, Email, MobileNumber, patienceHistory,  gender, bloodType;
   protected int  age,weight, height;
   public Patient(String Username, String Password) {
       this.Username = Username;
       this.Password = Password;
   }
   public Patient(String Username, String Password, String FirstName, String LastName, String Email) {
       this.Username = Username;
       this.Password = Password;
       this.FirstName = FirstName;
       this.LastName = LastName;
       this.Email = Email;
          }
          public Patient(String Username, String Password, String FirstName, String LastName, String Email, int age, int weight, int height) {
this(Username, Password, FirstName, LastName, Email);
this.age = age;
this.weight = weight;
this.height = height;
          }
          public String getUsername() {
       return Username;
          }
          public void setUsername(String username) {
       this.Username = username;
          }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getPatienceHistory() {
        return patienceHistory;
    }

    public void setPatienceHistory(String patienceHistory) {
        this.patienceHistory = patienceHistory;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



}
