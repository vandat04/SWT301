package dattv.example;

import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ResourceLeakExample {
    private static final Logger LOGGER = Logger.getLogger(ResourceLeakExample.class.getName());

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) LOGGER.info("Read line: " + line);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException occurred", e);
        }
    }
}