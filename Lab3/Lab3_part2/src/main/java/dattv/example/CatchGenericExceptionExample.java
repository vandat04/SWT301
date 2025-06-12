package dattv.example;

import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    public static void main(String[] args) {
        try {
            String s = null;
            Logger.getLogger(String.valueOf(s.length()));
        } catch (Exception e) {
            Logger.getLogger("Something went wrong");
        }
    }
}
