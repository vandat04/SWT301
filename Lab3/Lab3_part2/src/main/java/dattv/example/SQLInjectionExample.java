package dattv.example;


import java.util.logging.Logger;

public class SQLInjectionExample {
    public static void main(String[] args) {
        String userInput = "' OR '1'='1";
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        Logger.getLogger("Executing query: " + query);
    }
}
