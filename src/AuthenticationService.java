import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    public AuthenticationService() {
        users = new ArrayList<>();
        // Add a default user
        users.add(new User("guest", "guest"));
    }

    /**
     * signs up new username if username not taken
     * @param username is the username of user.
     * @param password is the password of user.
     * @return null if username is taken, otherwise create new user and save it in array and return newuser
     */
    @Override
    public User signUp(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return null;
            }
        }

        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Signup successful");
        return newUser;
    }

    /**
     * logs in after checking if username and password matches data in array
     * @param username is the username of user.
     * @param password is the password of user.
     * @return user if login is successful, otherwise return null
     */
    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }
        System.out.println("Wrong username or password.");
        return null;
    }

}