package dattv.example;

import java.util.logging.Logger;

public class HardcodedCredentialsExample {
    public static void main(String[] args) {
        String username = "admin";
        String password = "123456"; // hardcoded password
        if(authenticate(username, password)) {
            Logger.getLogger("Access granted");
        } else {
            Logger.getLogger("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        // Dummy authentication logic
        return user.equals("admin") && pass.equals("123456");
    }
}
