package dattv.example;

import java.util.logging.Logger;

public class UnreachableCodeExample {
    static final int BEST_NUMBER = 42;
    public static int getNumber() {
        return BEST_NUMBER;
    }

    public static void main(String[] args) {
        Logger.getLogger(String.valueOf(getNumber()));
    }
}
