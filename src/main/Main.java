import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager();

        // Add a hardcoded user
        loginManager.addUser(new User("Rana", "rana1234"));
        loginManager.addUser(new User("doctor1", "doctor1234"));

        // Get input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Attempt login
        if (loginManager.login(username, password)) {
            System.out.println("Welcome");
        } else {
            System.out.println("Login Failed");
        }

        scanner.close();
    }
}
