import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private List<User> users;

    public LoginManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Successful login
            }
        }
        return false; // Login failed
    }
}
