package Clinic;

public  class User {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String mobileNumber;

    public User(String firstName, String lastName, String username, String email, String password, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

}
