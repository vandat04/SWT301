package dattv.example;

import java.util.logging.Logger;

public class OvercatchingExceptionExample {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
           Logger.getLogger(String.valueOf(arr[10]));
        } catch (RuntimeException e) {
            Logger.getLogger("Runtime error");
        }
    }
}
