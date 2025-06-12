package dattv.example;

import java.util.logging.Logger;

public class InsecureLogin {
    public static void login(String username, String password) {
        if (username.equals("admin") && password.equals("123456")) {
            Logger.getAnonymousLogger("Login successful");
        } else {
            Logger.getAnonymousLogger("Login failed");
        }
    }

    public void printUserInfo(String user) {
        Logger.getAnonymousLogger("User: " + user);
    }

    public void doNothing() {
        // no operation
    }

}
