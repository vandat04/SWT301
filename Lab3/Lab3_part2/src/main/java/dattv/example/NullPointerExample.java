package dattv.example;

import java.util.logging.Logger;

public class NullPointerExample {
    public static void main(String[] args) {
        String text = null;
        if (!text.isEmpty()) {
            Logger.getLogger("Text is not empty");
        }
    }
}
